import java.util.*;
import java.io.*;

class tomato {
	int y, x;
	
	tomato(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Main {
	static int M, N;
	static int[][] map;
	static int[] dy = {-1, 1, 0, 0}; // 상, 하, 좌, 우
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // x
		N = Integer.parseInt(st.nextToken()); // y
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		BFS();
		
		//bw.flush();
		//bw.close();
		br.close();
	}
	
	static void BFS() {
		Queue<tomato> q = new LinkedList<>();
		
		for(int i = 0; i < N; i++) { // 익어있는 토마토 넣기
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1)
					q.add(new tomato(i, j));
			}
		}
		
		while(!q.isEmpty()) { // BFS
			tomato cur = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				
				if(ny < 0 || ny >= N || nx < 0 || nx >= M)
					continue;
				
				if(map[ny][nx] != 0)
					continue;
				
				map[ny][nx] = map[cur.y][cur.x] + 1;
				q.add(new tomato(ny, nx));
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) { // 익어있는 토마토 넣기
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				max = Math.max(map[i][j], max);
			}
		}
		System.out.println(max - 1);
	}
}