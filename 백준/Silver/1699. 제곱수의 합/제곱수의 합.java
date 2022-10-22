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
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[N + 1];
		
		if(N == 1 || N == 2) {
			System.out.println(N);
			System.exit(0);
		}
	
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		for(int i = 1; i <= Math.sqrt(N); i++) {
			dp[i*i] = 1;
		}
		
		dp[1] = 1; // 1
		dp[2] = 2; // 1 + 1
		dp[3] = 3;
		
		for(int i = 3; i <= N; i++) {
			for(int j = 1; j <= i/2; j++) {
				dp[i] = Math.min(dp[i], dp[i - j] + dp[j]);
			}
		}
		
		System.out.println(dp[N]);
	}
	
}