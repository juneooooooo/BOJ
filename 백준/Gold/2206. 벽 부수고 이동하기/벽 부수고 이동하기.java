import java.util.*;
import java.io.*;

class node {
	int y, x, cnt, broken;
	
	node(int y, int x, int cnt, int broken) {
		this.y = y;
		this.x = x;
		this.cnt = cnt;
		this.broken = broken;
	}
}

public class Main {
	static int N, M;
	static int[][] map;
	static int[] dy = {-1, 1, 0, 0}; // 상, 하, 좌, 우
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		System.out.println(BFS());
		
		//bw.flush();
		//bw.close();
		br.close();
	}
	
	static int BFS() {
		Queue<node> q = new LinkedList<>();
		boolean[][][] visited = new boolean[N][M][2]; // [][][0] : 벽 부수지 않은 상태
	                                          		  // [][][1] : 벽 1개 부순 상태
		
		q.add(new node(0, 0, 1, 0)); // y, x, cnt, broken
		visited[0][0][0] = true;
		
		while(!q.isEmpty()) {
			node cur = q.poll();
			
			if(cur.y == N - 1 && cur.x == M - 1) {
				return cur.cnt;
			}
			
			for(int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				
				if(ny < 0 || ny >= N || nx < 0 || nx >= M)
					continue;
				
				if(map[ny][nx] == 0 && !visited[ny][nx][cur.broken]) {
					q.add(new node(ny, nx, cur.cnt + 1, cur.broken));
					visited[ny][nx][cur.broken] = true; 
				}
				else if(map[ny][nx] == 1 && cur.broken == 0 && !visited[ny][nx][1]) {
					q.add(new node(ny, nx, cur.cnt + 1, 1));
					visited[ny][nx][1] = true;
				}
			}
		}
		
		return -1;
	}
	
}