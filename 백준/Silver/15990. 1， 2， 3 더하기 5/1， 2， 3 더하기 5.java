import java.util.*;
import java.io.*;

/*
Arrays.sort(time, new Comparator<int[]>() {
		
		@Override
		public int compare(int[] a, int[] b) {
			if(a[1] == b[1]) {
				return a[0] - b[0];
			}
			
			return a[1] - b[1];
		}
	}); //  [두 수의 비교 결과에 따른 작동 방식]
		//	음수일 경우 : 두 원소의 위치를 교환 안함
		//	양수일 경우 : 두 원소의 위치를 교환 함
*/

public class Main {
	static final long mod = 1_000_000_009;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		long[][] dp = new long[100_001][4];
		
		dp[1][1] = 1; // 1
		dp[2][2] = 1; // 2
		dp[3][1] = 1; // 2 + 1
		dp[3][2] = 1; // 1 + 2
		dp[3][3] = 1; // 3
		
		for(int i = 4; i <= 100_000; i++) {
			dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % mod;
			dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % mod;
			dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % mod;
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			
			sb.append((dp[N][1] + dp[N][2] + dp[N][3]) % mod).append("\n");
		}
		System.out.println(sb);
	}
	
}