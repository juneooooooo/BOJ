import java.util.*;
import java.io.*;

public class Main {
	static boolean[] visited;
	static ArrayList<Integer>[] edges;
	static Queue<Integer> q;
	static ArrayList<Integer> answer = new ArrayList<>();
	static int N, M, V;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 정점
		M = Integer.parseInt(st.nextToken()); // 간선
		V = Integer.parseInt(st.nextToken()); // 시작 정점
		visited = new boolean[N + 1];
		
		edges = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++)
			edges[i] = new ArrayList<Integer>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			edges[u].add(v);
			edges[v].add(u);
		}
		
		for(int i = 1; i <= N; i++) // 인접정점 오름차순으로 방문 위한 정렬
			Collections.sort(edges[i]);
		
		DFS(V); // DFS
		
		StringBuilder sb = new StringBuilder();
		for(int cur : answer) 
			sb.append(cur).append(" ");
		System.out.println(sb);
		
		Arrays.fill(visited, false);
		answer.clear();
		
		q = new LinkedList<>();
		q.offer(V);
		visited[V] = true;
		answer.add(V);
		
		while(!q.isEmpty()) { // BFS
			int cur = q.poll();
			
			for(int next : edges[cur]) { // cur와 연결된 정점 확인
				if(!visited[next]) {
					q.offer(next);
					visited[next] = true;
					answer.add(next);
				}
			}
		}
		
		sb = new StringBuilder();
		for(int cur : answer) 
			sb.append(cur).append(" ");
		System.out.println(sb);
		
		//bw.flush();
		//bw.close();
		//br.close();
	}
	
	static void DFS(int cur) {
		visited[cur] = true;
		answer.add(cur);
		
		for(int next : edges[cur]) {
			if(!visited[next])
				DFS(next);
		}
	}
}