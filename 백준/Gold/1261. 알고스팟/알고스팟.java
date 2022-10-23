import java.util.*;
import java.io.*;

class node {
	int y, x, wall;
	node(int y, int x, int wall) {
		this.y = y;
		this.x = x;
		this.wall = wall;
	}
}

public class Main {
	static int M, N;
	static boolean[][] visited;
	static int[][] map;
	static int[] dy = {-1, 1, 0, 0}; // 상, 하, 좌, 우
	static int[] dx = {0, 0, -1, 1};
	static int answer = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); // x 가로
		N = Integer.parseInt(st.nextToken()); // y 세로
		visited = new boolean[N][M];
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		BFS();
		
		System.out.println(answer);
		
	}
	
	static void BFS() {
		Deque<node> dq = new LinkedList<>();
		
		dq.addFirst(new node(0, 0, 0));
		visited[0][0] = true;
		
		while(!dq.isEmpty()) {
			node cur = dq.pollFirst(); // 앞에꺼 부터 꺼내기
			
			if(cur.y == N - 1 && cur.x == M - 1) {
				answer = cur.wall;
				return;
			}
			
			for(int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				
				if(ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx])
					continue;
				
				if(map[ny][nx] == 0)
					dq.addFirst(new node(ny, nx, cur.wall)); // 가중치 0은 앞으로
				else
					dq.addLast(new node(ny, nx, cur.wall + 1)); // 가중치 1은 뒤로
				
				visited[ny][nx] = true;
			}
		}
	}
}