import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		long[][] dp = new long[N + 1][10]; // N : 자리수, 10 : 끝자리 0~9 까지 총 10가지 
		long mod = 1000000000;
				
		for(int i = 1; i <= 9; i++) {
			dp[1][i] = 1;
		}
		
		for(int i = 2; i <= N; i++) {
			for(int j = 0; j < 10; j++) {
				if(j == 0)
					dp[i][j] = dp[i - 1][j + 1] % mod; // 끝자리 0이면 1일때만 확인
				else if(j == 9)
					dp[i][j] = dp[i - 1][j - 1] % mod; // 끝자리 9이면 8일때만 확인
				else
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
			}
		}
		
		long sum = 0;
		for(int i = 0; i < 10; i++)
			sum += dp[N][i] % mod;
		
		System.out.println(sum % mod);
		
	}
}