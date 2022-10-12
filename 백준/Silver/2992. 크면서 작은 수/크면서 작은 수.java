import java.util.*;
import java.io.*;

public class Main {
	static int X, N; // N : 자리수
	static int min = Integer.MAX_VALUE;
	static int[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		N = s.length();
		X = Integer.parseInt(s);
		
		visited = new boolean[N];
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = s.charAt(i) - '0';
		}
		
		DFS(0, 0);
		
		if(min != Integer.MAX_VALUE)
			System.out.println(min);
		else
			System.out.println(0);
		
		//bw.flush();
		//bw.close();
		br.close();
	}

	static void DFS(int depth, int sum) {
		if(depth == N) {
			if(sum > X) 
				min = Math.min(min, sum);
			
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				DFS(depth + 1, sum + (arr[i] * (int) Math.pow(10, N - depth - 1)));
				visited[i] = false;
			}
		}
	}
}