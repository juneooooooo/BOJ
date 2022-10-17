import java.util.*;
import java.io.*;

public class Main {
	static long[] dp = new long[101];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			
			dp[1] = 1;
			dp[2] = 1;
			dp[3] = 1;
			
			for(int i = 4; i <= N; i++) {
				dp[i] = dp[i - 2] + dp[i - 3];
			}
			
			System.out.println(dp[N]);
		}
	}
}