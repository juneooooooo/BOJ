import java.util.*;
import java.io.*;

public class Main {
	static int T, N, M, K;
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = {0, 0, -1, 1}; // 좌, 우, 상, 하
	static int[] dx = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new boolean[N][M];
			int cnt = 0;
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				
				map[Y][X] = 1;
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						DFS(i, j);
						
						cnt++;
					}
				}
			}
			
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
		
		//bw.flush();
		//bw.close();
		br.close();
	}
	
	static void DFS(int y, int x) {
		visited[y][x] = true;
		
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny < 0 || ny >= N || nx < 0 || nx >= M)
				continue;
			
			if(map[ny][nx] == 1 && !visited[ny][nx]) {
				DFS(ny, nx);
			}
		}
	}
}