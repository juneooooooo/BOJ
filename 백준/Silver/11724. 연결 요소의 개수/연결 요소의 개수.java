import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Integer>[] edge;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 정점
		int M = Integer.parseInt(st.nextToken()); // 간선
		int answer = 0;
		visited = new boolean[N + 1];
		
		
		edge = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			edge[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			edge[u].add(v);
			edge[v].add(u);
		}
		
		for(int i = 1; i <= N; i++) {
			Collections.sort(edge[i]);
		}
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				DFS(i);
				answer++;
			}
		}
		
		System.out.println(answer);
		
		//bw.flush();
		//bw.close();
		br.close();
	}
	
	static void DFS(int idx) {
		visited[idx] = true;
		
		for(int next : edge[idx]) {
			if(!visited[next])
				DFS(next);
		}
	}
}