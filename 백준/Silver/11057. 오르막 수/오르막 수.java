import java.util.*;
import java.io.*;

public class Main {
	static final int mod = 10_007;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		// dp[i][j] => 길이가 i이면서 끝자리가 j인 오르막수의 개수
		long[][] dp = new long[N + 1][10];
		
		for(int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		for(int i = 1; i <= N; i++) {
			dp[i][0] = 1;
		}
		
		for(int i = 2; i <= N; i++) {
			for(int j = 1; j < 10; j++) {
				dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % mod;
			}
		}
		
		long answer = 0;
		for(int i = 0; i < 10; i++)
			answer += (dp[N][i] % mod);
		
		System.out.println(answer % mod);
	}
}