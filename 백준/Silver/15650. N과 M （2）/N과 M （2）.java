import java.util.*;
import java.io.*;

public class Main {
	static int[] arr;
	static boolean[] visited;
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // nPm
		
		arr = new int[N + 1];
		visited = new boolean[N + 1];
		
		for(int i = 1; i <= N; i++)
			arr[i] = i;
		
		DFS(1, 0);
		
		System.out.println(sb);
		
		//bw.flush();
		//bw.close();
		br.close();
	}
	
	static void DFS(int idx, int r) {
		if(r == M) {
			for(int i = 1; i <= N; i++) {
				if(visited[i])
					sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = idx; i <= N; i++) {
			//if(!visited[i]) {
				visited[i] = true;
				DFS(i + 1, r + 1);
				visited[i] = false;
			//}
		}
	}
}