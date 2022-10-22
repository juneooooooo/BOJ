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
	static int[][] map;
	static int N, M, K;
	static int max = Integer.MIN_VALUE;
	static int[] dy = {-1, 1, 0, 0}; // 상, 하, 좌, 우 
	static int[] dx = {0, 0, -1, 1};
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N + 1][M + 1];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		DFS(0, 0, 0, 0);
		
		System.out.println(max);
	}
	
	static void DFS(int depth, int y, int x, int sum) {
		if(depth == K) {
			max = Math.max(max, sum);
			return;
		}
		else {
			for(int i = y; i < N; i++) {
				for(int j = x; j < M; j++) {
					if(!visited[i][j]) {
						if(isVisit(i, j)) {
							visited[i][j] = true;
							DFS(depth + 1, y, x, sum + map[i][j]);
							visited[i][j] = false;
						}	
					}
				}
			}
		}
	}
	
	static boolean isVisit(int y, int x) { // 상, 하, 좌, 우 중 1곳이라도 인접한곳이 있는지 확인
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny >= 0 && ny < N && nx >= 0 && nx < M) {
				if(visited[ny][nx]) {
					return false;
				}
			}
		}
		return true;
	}
}