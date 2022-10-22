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
	static int N, M;
	static int max = Integer.MIN_VALUE;
	static int[] dy = {-1, 1, 0, 0}; // 상, 하, 좌, 우
	static int[] dx = {0, 0, -1, 1};
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				visited[i][j] = true;
				DFS(1, i, j, map[i][j]);
				visited[i][j] = false;
				
				more(i, j);
			}
		}
		
		System.out.println(max);
	}
	
	static void DFS(int depth, int y, int x, int sum) {
		if(depth == 4) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx])
				continue;
			
			visited[ny][nx] = true;
			DFS(depth + 1, ny, nx, sum + map[ny][nx]);
			visited[ny][nx] = false;
		}
	}
	
	static void more(int y, int x) { // ㅗ 모양은 dfs로 확인이 안되서 따로 확인
		if(y < N - 2 && x < M - 1)
			max = Math.max(max,  map[y][x] + map[y + 1][x] + map[y + 2][x] + map[y + 1][x + 1]); // ㅏ
		
		if(y < N - 2 && x > 0)
			max = Math.max(max,  map[y][x] + map[y + 1][x] + map[y + 2][x] + map[y + 1][x - 1]); // ㅓ
		
		if(y < N - 1 && x < M - 2)
			max = Math.max(max,  map[y][x] + map[y][x + 1] + map[y][x + 2] + map[y + 1][x + 1]); // ㅗ
		
		if(y > 0 && x < M - 2)
			max = Math.max(max,  map[y][x] + map[y][x + 1] + map[y][x + 2] + map[y - 1][x + 1]); // ㅜ
	}
}