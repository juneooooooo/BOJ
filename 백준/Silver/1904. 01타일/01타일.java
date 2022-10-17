import java.util.*;
import java.io.*;

public class Main {
	static long[] dp = new long[1000001];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i = 3; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
			dp[i] %= 15746;
		}
		
		System.out.println(dp[N]);
	}
}