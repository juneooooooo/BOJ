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
		
		int n = N, m = M;
		
		for(int i = 0; i < rotate; i++) { // 그룹별로 회전
			rotation(i, 2*n + 2*m - 4);
			n -= 2;
			m -= 2;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void rotation(int start, int len) {
		int r = R % len;
		
		for(int i = 0; i < r; i++) {
			int temp = map[start][start];
			
			int edgeCount = 0; // 모서리일때 방향 전환
			int y = start, x = start;
			
			while(edgeCount < 4) {
				int ny = y + dy[edgeCount];
				int nx = x + dx[edgeCount];
				
				if(ny >= start && nx >= start && ny < N - start && nx < M - start) {
					map[y][x] = map[ny][nx];
					y = ny;
					x = nx;
				}
				else {
					edgeCount++;
				}
			}
			
			map[start + 1][start] = temp;
		}
	}
}