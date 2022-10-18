import java.util.*;
import java.io.*;

/*
Arrays.sort(time, new Comparator<int[]>() {
		
		@Override
		public int compare(int[] a, int[] b) {
			if(a[1] == b[1]) {
				return a[0] - b[0];
			}
			
			return a[1] - b[1];
		}
	}); //  [두 수의 비교 결과에 따른 작동 방식]
		//	음수일 경우 : 두 원소의 위치를 교환 안함
		//	양수일 경우 : 두 원소의 위치를 교환 함
*/

class node {
	int dist, idx;
	node(int dist, int idx) {
		this.dist = dist;
		this.idx = idx;
	}
}

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken()); // 정점
		int E = Integer.parseInt(st.nextToken()); // 간선
		int start = Integer.parseInt(br.readLine());
		
		// 다익스트라 : 간선의 가중치가 있는 경우 한 시작점에서 다른 지점들까지 각각의 최단경로를 구하는 알고리즘.
		int[] dist = new int[V + 1]; // start부터 [idx] 까지의 최단거리
		boolean[] visited = new boolean[V + 1]; // 정점 방문여부
		ArrayList<node>[] map = new ArrayList[V + 1];
		for(int i = 1; i <= V; i++)
			map[i] = new ArrayList<>();
		
		Arrays.fill(dist, Integer.MAX_VALUE); // 최단거리 테이블 초기화
		
		for(int i = 0; i < E; i++) { // map[a][b] == 0이면 연결 X
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			map[u].add(new node(w, v)); 
		}
		
		dist[start] = 0;
		
		int min = 0, cur = 1;
		for(int i = 1; i <= V; i++) {
			min = Integer.MAX_VALUE;
			
			// 방문하지 않은 정점 중에, 현재 정점(i)에서 가장 가까운 정점(j) 찾기
			for(int j = 1; j <= V; j++) {
				if(!visited[j] && dist[j] < min) {
					min = dist[j];
					cur = j; // 가장 가까운 정점
				}
			}
			
			visited[cur] = true;
			
			for(int j = 0; j < map[cur].size(); j++) {
				node next = map[cur].get(j);
				
				if(dist[next.idx] > dist[cur] + next.dist)
					dist[next.idx] = dist[cur] + next.dist;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= V; i++) {
			if(dist[i] == Integer.MAX_VALUE)
				sb.append("INF\n");
			else
				sb.append(dist[i]).append("\n");
		}
		
		System.out.println(sb);
	}

}