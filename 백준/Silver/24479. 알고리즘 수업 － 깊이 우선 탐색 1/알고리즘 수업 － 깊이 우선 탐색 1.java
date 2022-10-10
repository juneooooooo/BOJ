import java.util.*;
import java.io.*;

public class Main {
	static boolean[] visited;
	static ArrayList<Integer>[] edges;
	static int[] answer;
	static int N, M, R;
	static int cnt = 2;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 정점
		M = Integer.parseInt(st.nextToken()); // 간선
		R = Integer.parseInt(st.nextToken()); // 시작 정점
		
		visited = new boolean[N + 1];
		answer = new int[N + 1];
		
		edges = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) 
			edges[i] = new ArrayList<>();
		
		int u = 0;
		int v = 0;
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			
			edges[u].add(v);
			edges[v].add(u);
		}
		
		for(int i = 1; i <= N; i++) // 인접 정점은 오름차순으로 방문하기 위해 오름차순 정렬
			Collections.sort(edges[i]);
		
		visited[R] = true;
		answer[R] = 1;
		DFS(R);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) 
			sb.append(answer[i]).append("\n");
		
		System.out.println(sb);
		
		//bw.flush();
		//bw.close();
		//br.close();
	}
	
	static void DFS(int v) {	
		for(int next : edges[v]) {
			if(!visited[next]) {
				answer[next] = cnt++;
				visited[next] = true;
				DFS(next);
			}
		}
	}
}