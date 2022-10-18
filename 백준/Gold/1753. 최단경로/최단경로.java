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

class node implements Comparable<node> {
	int dist, idx;
	
	public node(int dist, int idx) {
		this.dist = dist;
		this.idx = idx;
	}
	
	@Override
	public int compareTo(node n) {
		return this.dist - n.dist;
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
		
		ArrayList<node>[] map = new ArrayList[V + 1];
		for(int i = 1; i <= V; i++)
			map[i] = new ArrayList<>();
		
		Arrays.fill(dist, Integer.MAX_VALUE); // 최단거리 테이블 초기화
		
		PriorityQueue<node> pq = new PriorityQueue<>();
		
		for(int i = 0; i < E; i++) { // map[a][b] == 0이면 연결 X
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			map[u].add(new node(w, v)); 
		}
		
		dist[start] = 0;
		pq.add(new node(0, start));
		
		while(!pq.isEmpty()) {
			node n = pq.poll();
			
			// 현재 노드가 이미 처리된 적이 있다면 무시
			if(dist[n.idx] < n.dist)
				continue;
			
			// 현재 노드와 연결된 다른 인접한 노드들을 확인
			for(node next : map[n.idx]) {
				int cost = n.dist + next.dist;
				
				// 현재 노드를 거쳐서, 다음 노드로 이동하는 거리가 더 짧은 경우
				if(cost < dist[next.idx]) {
					dist[next.idx] = cost;
					pq.add(new node(cost, next.idx));
				}
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