import java.util.*;
import java.io.*;

public class Main {
	static int N, M, R, rotate;
	static int[][] map;
	static int[] dy = {0, 1, 0, -1}; // 우 하 좌 상
	static int[] dx = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // y
		M = Integer.parseInt(st.nextToken()); // x
		R = Integer.parseInt(st.nextToken()); // 연산 횟수
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		rotate = Math.min(N, M) / 2; // 회전시킬 그룹의 수
		
		for(int i = 0; i < R; i++)
			rotation();
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void rotation() {
		for(int i = 0; i < rotate; i++) {
			int temp = map[i][i];
			
			int dydx = 0; // 상 하 좌 우 총 4가지 경우
			int y = i, x = i;
			
			while(dydx < 4) {
				int ny = y + dy[dydx];
				int nx = x + dx[dydx];
				
				if(ny >= i && nx >= i && ny < N - i && nx < M - i) {
					map[y][x] = map[ny][nx];
					y = ny;
					x = nx;
				}
				else {
					dydx++;
				}
			}
			
			map[i + 1][i] = temp;
		}
	}
}