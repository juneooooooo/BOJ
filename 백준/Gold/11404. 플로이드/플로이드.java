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

public class Main {
	static final int INF = 987654321;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int V = Integer.parseInt(br.readLine()); // 정점
		int E = Integer.parseInt(br.readLine()); // 간선
		
		int[][] map = new int[V + 1][V + 1];
		
		for(int i = 1; i <= V; i++) { // 그래프 초기화
			for(int j = 1; j <= V; j++) {
				map[i][j] = INF;
				
				if(i == j) 
					map[i][j] = 0;
			}
		}
		
		StringTokenizer st;
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			map[u][v] = Math.min(map[u][v], w);
		}
		
		for(int k = 1; k <= V; k++) {
			for(int i = 1; i <= V; i++) {
				for(int j = 1; j <= V; j++) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= V; i++) {
			for(int j = 1; j <= V; j++) {
				if(map[i][j] == INF)
					map[i][j] = 0;
				
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}