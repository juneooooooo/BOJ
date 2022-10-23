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
	int idx, dist;
	node(int idx, int dist) {
		this.dist = dist;
		this.idx = idx;
	}
	
	@Override
	public int compareTo(node n) {
		return this.dist - n.dist;
	}
}

public class Main {
	static int N, M, start, end;
	static int[] dist;
	static boolean[] visited;
	static ArrayList<node>[] map;
	static final int INF = 987654321;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine()); // 정점(도시)
		M = Integer.parseInt(br.readLine()); // 간선(버스)
		dist = new int[N + 1];
		visited = new boolean[N + 1];
		
		map = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			map[i] = new ArrayList<>();
			dist[i] = INF; 
		}
		
		StringTokenizer st;
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			map[u].add(new node(v, w));
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		PriorityQueue<node> pq = new PriorityQueue<>();
		
		// node(idx, dist)
		pq.add(new node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			node cur = pq.poll();
			
			if(dist[cur.idx] < cur.dist) // 방문 했었는지 확인
				continue;
			
			for(node next : map[cur.idx]) {
				int cost = cur.dist + next.dist;
				
				if(cost < dist[next.idx]) { // 최단거리 갱신하고 pq에 넣기
					dist[next.idx] = cost;
					pq.add(new node(next.idx, cost));
				}
					
			}
		}
		
		System.out.println(dist[end]);
	}
	
}