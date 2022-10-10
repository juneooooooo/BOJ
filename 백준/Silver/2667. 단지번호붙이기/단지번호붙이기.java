import java.util.*;
import java.io.*;

public class Main {
	static int N, cnt = 0;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Integer> answer = new ArrayList<>();
	static int[] dy = {0, 0, -1, 1}; // 좌, 우, 상, 하
	static int[] dx = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					DFS(i, j);
					
					answer.add(cnt);
					cnt = 0;
				}
			}
		}
		
		
		StringBuilder sb = new StringBuilder();
		sb.append(answer.size()).append("\n");
		Collections.sort(answer);
		for(int cur : answer)
			sb.append(cur).append("\n");
		
		System.out.println(sb);
		
		//bw.flush();
		//bw.close();
		br.close();
	}
	
	static void DFS(int y, int x) {
		visited[y][x] = true;
		cnt++;
		
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny < 0 || ny >= N || nx < 0 || nx >= N)
				continue;
			
			if(map[ny][nx] == 1 && !visited[ny][nx]) {
				DFS(ny, nx);
			}
		}
	}
}