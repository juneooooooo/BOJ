import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] arr;
	static int[] result;
	static boolean[] visited;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		result = new int[N];
		visited = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		DFS(0);
		
		System.out.println(max);
		
		//bw.flush();
		//bw.close();
		br.close();
	}
	
	static void DFS(int depth) {
		if(depth == N) {
			int sum = 0;
			for(int i = 0; i < N - 1; i++) {
				sum += Math.abs(result[i] - result[i + 1]);
			}
			max = Math.max(max, sum);
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