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
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] dy = {-2, -2, 0, 0, 2, 2};
		int[] dx = {-1, 1, -2, 2, -1, 1};
		
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		boolean[][] visited = new boolean[N][N];
		
		Queue<node> q = new LinkedList<>();
		visited[r1][c1] = true;
		q.add(new node(r1, c1, 0));
		
		while(!q.isEmpty()) {
			node cur = q.poll();
			
			if(cur.y == r2 && cur.x == c2) {
				answer = cur.dist;
				break;
			}
			
			for(int i = 0; i < dy.length; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				
				if(ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx])
					continue;
				
				q.add(new node(ny, nx, cur.dist + 1));
				visited[ny][nx] = true;
			}
		}
		
		System.out.println(answer == 0 ? -1 : answer);
		
	}
}