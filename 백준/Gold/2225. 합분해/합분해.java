import java.util.*;
import java.io.*;

public class Main {
	static final long mod = 1_000_000_000;
	static int N, K;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		long[][] dp = new long[N + 1][K + 1];
		
		for(int i = 1; i <= K; i++) {
			dp[0][i] = 1;
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= K; j++) {
				dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % mod;
			}
		}
		
		System.out.println(dp[N][K]);
	}
}