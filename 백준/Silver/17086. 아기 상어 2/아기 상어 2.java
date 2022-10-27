import java.util.*;
import java.io.*;

class node {
	int y, x, dist;
	node(int y, int x, int dist) {
		this.y = y;
		this.x = x;
		this.dist = dist;
	}
}

public class Main {
	static int N, M, max = Integer.MIN_VALUE;
	static int[][] map;
	static int[] dy = {-1, -1, 1, 1, -1, 1, 0, 0}; // 좌상, 우상, 좌하, 우하, 상, 하, 좌, 우 
	static int[] dx = {-1, 1, -1, 1, 0, 0, -1, 1};
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
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
				if(map[i][j] == 0) {
					max = Math.max(max, BFS(i, j));
				}
			}
		}
		
		System.out.println(max);
	}
	
	private static int BFS(int sy, int sx) {
		visited = new boolean[N][M];
		Queue<node> q = new LinkedList<>();
		q.add(new node(sy, sx, 0));
		visited[sy][sx] = true;
		
		int y, x, dist;
		while(!q.isEmpty()) {
			node cur = q.poll();
			y = cur.y;
			x = cur.x;
			dist = cur.dist;
			
			if(map[y][x] == 1)
				return dist;
		
			for(int i = 0; i < 8; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx])
					continue;
				
				q.add(new node(ny, nx, dist + 1));
				visited[ny][nx] = true;
			}
		}
		
		return 0;
	}
}