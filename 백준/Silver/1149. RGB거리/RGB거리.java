import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[][] colors = new int[N][N];
		int[][] dp = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < 3; j++) {
				colors[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = colors[0][0];
		dp[0][1] = colors[0][1];
		dp[0][2] = colors[0][2];
		
		for(int i = 1; i < N; i++) {
			dp[i][0] = colors[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
			dp[i][1] = colors[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
			dp[i][2] = colors[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
		}
		
		int answer = Math.min(dp[N - 1][0], Math.min(dp[N - 1][1], dp[N - 1][2]));
		
		System.out.println(answer);
		
		// dp[n][m] : n번째에서 m을 선택한 경우
		
	}
}