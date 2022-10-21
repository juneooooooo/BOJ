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
		
		int T = Integer.parseInt(br.readLine());
		long[] fx = new long[1000001];
		long[] dp = new long[1000001];
		
		Arrays.fill(fx, 1); // 1은 모든 수의 약수
		
		for(int i = 2; i < fx.length; i++) { // 배수
			for(int j = 1; i*j < fx.length; j++) {
				fx[i * j] += i;
			}
		}
		
		for(int i = 1; i < dp.length; i++) // g(x) = g(x - 1) + f(x)
			dp[i] = dp[i - 1] + fx[i];
		
		StringBuilder sb = new StringBuilder();
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			
			sb.append(dp[N]).append("\n");
		}
		System.out.println(sb);
	}
	
}