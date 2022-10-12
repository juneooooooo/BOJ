import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] arr;
	static int[] result;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		result = new int[N];
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}
		
		DFS(0);
		
		System.out.println(sb);
		
		//bw.flush();
		//bw.close();
		br.close();
	}
	
	static void DFS(int depth) {
		if(depth == N) {
			int sum = 0;
			for(int i = 0; i < N; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[depth] = arr[i];
				DFS(depth + 1);
				visited[i] = false;
			}
		}
	}
	
}