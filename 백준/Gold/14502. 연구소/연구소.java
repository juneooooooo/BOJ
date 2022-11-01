import java.util.*;
import java.io.*;

class node{
	int y, x;
	node(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Main {
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int[][] map;
	static ArrayList<node> virus = new ArrayList<>();
	static ArrayList<node> zero = new ArrayList<>();
	static int N, M, answer = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0)
					zero.add(new node(i, j));
				else if(map[i][j] == 2)
					virus.add(new node(i, j));
			}
		}
		
		for(int i = 0; i < zero.size() - 2; i++) { // 벽 3개 세우기
			for(int j = i + 1; j < zero.size() - 1; j++) {
				for(int k = j + 1; k < zero.size(); k++) {
					BFS(i, j, k);
				}
			}
		}
		
		System.out.println(answer);
	}
	
	static void BFS(int w1, int w2, int w3) {
		int[][] n_map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++)
				n_map[i][j] = map[i][j];
		}
		
		n_map[zero.get(w1).y][zero.get(w1).x] = 1;
		n_map[zero.get(w2).y][zero.get(w2).x] = 1;
		n_map[zero.get(w3).y][zero.get(w3).x] = 1;
		
		Queue<node> q = new LinkedList<>();
		for(int i = 0; i < virus.size(); i++) {
			q.add(new node(virus.get(i).y, virus.get(i).x));
		}
		
		while(!q.isEmpty()) {
			node cur = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				
				if(ny < 0 || ny >= N || nx < 0 || nx >= M || n_map[ny][nx] == 1)
					continue;
				
				if(n_map[ny][nx] == 0) {
					q.add(new node(ny, nx));
					n_map[ny][nx] = 2;
				}
			}
		}
		
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(n_map[i][j] == 0)
					cnt++;
			}
		}
	
		answer = Math.max(answer, cnt);
		
		return;
	}
}