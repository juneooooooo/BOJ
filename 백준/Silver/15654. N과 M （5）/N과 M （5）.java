import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] arr;
	static boolean[] visited;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // nPm
		arr = new int[N];
		visited = new boolean[N];
		result = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		DFS(0);
		
		System.out.println(sb);
		
		//bw.flush();
		//bw.close();
		br.close();
	}
	
	static void DFS(int depth) {
		if(depth == M) {
			for(int i = 0; i < M; i++) {
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