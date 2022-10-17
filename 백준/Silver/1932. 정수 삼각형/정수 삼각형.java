import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[][] cost = new int[n + 1][n + 1];
		int[][] dp = new int[n + 1][n + 1];
		int max = Integer.MIN_VALUE;
		
		for(int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= i; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[1][1] = cost[1][1];
		
		for(int i = 2; i <= n; i++) {
			for(int j = 1; j <= i; j++) {
				if(j == 1) 
					dp[i][j] = cost[i][j] + dp[i - 1][j];
				else
					dp[i][j] = cost[i][j] + Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
			}
		}
		
		for(int i = 1; i <= n; i++)
			max = Math.max(max, dp[n][i]);
		
		System.out.println(max);
		
	}
}