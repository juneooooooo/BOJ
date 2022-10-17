import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int X = Integer.parseInt(br.readLine());
		int[] dp = new int[X + 1];
		
		for(int i = 2; i <= X; i++) {
			dp[i] = dp[i - 1] + 1; // 1을 뺀다.
			
			if(i % 3 == 0) 
				dp[i] = Math.min(dp[i], dp[i / 3] + 1); // 3으로 나눈다.
			
			if(i % 2 == 0)
				dp[i] = Math.min(dp[i], dp[i / 2] + 1); // 2로 나눈다.
		}
		
		System.out.println(dp[X]);
	}
}