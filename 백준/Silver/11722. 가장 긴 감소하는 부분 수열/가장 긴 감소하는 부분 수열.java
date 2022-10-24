import java.util.*;
import java.io.*;

public class Main {
	static final int mod = 10_007;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		int[] dp = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = i + 1; j <= N; j++) {
				if(arr[i] > arr[j]) {
					dp[j] = Math.max(dp[j], dp[i] + 1);
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		
		for(int i = 1; i <= N; i++) 
			max = Math.max(max, dp[i]);
		
		System.out.println(max);
	}
}