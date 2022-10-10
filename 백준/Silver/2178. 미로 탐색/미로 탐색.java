import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static Queue<int[]> q = new LinkedList<>();
	static int[] dy = {0, 0, -1, 1}; // 좌, 우, 상, 하
	static int[] dx = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		BFS(0, 0);
		
		System.out.println(map[N - 1][M - 1]);
		//bw.flush();
		//bw.close();
		br.close();
	}
	
	static void BFS(int y, int x) {
		q.add(new int[] {y, x});
		visited[y][x] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cur_y = cur[0];
			int cur_x = cur[1];
			
			for(int i = 0; i < 4; i++) {
				int ny = cur_y + dy[i];
				int nx = cur_x + dx[i];
				
				if(ny >= N || ny < 0 || nx >= M || nx < 0) 
					continue;
				
				if(!visited[ny][nx] && map[ny][nx] == 1) {
					q.add(new int[] {ny, nx});
					visited[ny][nx] = true;
					map[ny][nx] = map[cur_y][cur_x] + 1;
				}
				
			}
		}
	}
}