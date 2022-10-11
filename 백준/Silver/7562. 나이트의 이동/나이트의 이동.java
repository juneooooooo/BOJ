import java.util.*;
import java.io.*;

class Pos {
	int y, x;
	
	Pos(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Main {
	static int N, l;
	static int[][] visited;
	static int[] dy = {-2, -2, -1, 1, 2, 2, -1, 1};
	static int[] dx = {-1, 1, 2, 2, 1, -1, -2, -2};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(T-- > 0) {
			l = Integer.parseInt(br.readLine());
			visited = new int[l][l];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			Pos start = new Pos(y, x);
			
			st = new StringTokenizer(br.readLine());
			int ny = Integer.parseInt(st.nextToken());
			int nx = Integer.parseInt(st.nextToken());
			Pos end = new Pos(ny, nx);
			
			BFS(start, end);
			
			sb.append(visited[ny][nx] - 1).append("\n");
		}
		
		System.out.println(sb);
		//bw.flush();
		//bw.close();
		br.close();
	}
	
	static void BFS(Pos start, Pos end) {
		Queue<Pos> q = new LinkedList<>();
		q.add(start);
		visited[start.y][start.x] = 1;
		
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			
			if(cur.y == end.y && cur.x == end.x) {
				return;
			}
			
			for(int i = 0; i < 8; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				
				if(ny < 0 || ny >= l || nx < 0 || nx >= l)
					continue;
				
				if(visited[ny][nx] == 0) {
					visited[ny][nx] = visited[cur.y][cur.x] + 1;
					q.add(new Pos(ny, nx));
				}
			}
		}
	}
}