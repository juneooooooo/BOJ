import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[10001];
		int[] dp = new int[10001];
		
		for(int i = 1; i <= N; i++)
			num[i] = Integer.parseInt(br.readLine());
		
		dp[1] = num[1];
		dp[2] = num[1] + num[2];
		
		for(int i = 3; i <= N; i++)
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2], dp[i - 3] + num[i - 1]) + num[i]);
		
		System.out.println(dp[N]);
	}
}