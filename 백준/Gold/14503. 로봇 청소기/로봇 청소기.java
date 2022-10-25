import java.util.*;
import java.io.*;

public class Main {
	static int[][] map;
	static int[] dy = {-1, 0, 1, 0}; // 북, 동, 남, 서
	static int[] dx = {0, 1, 0, -1}; // 북(0) -> 서(3) -> 남(2) -> 동(1) -> 북(0)... 순서로 확인
	static int[] next = {3, 0, 1, 2};
	static int N, M, d, sy, sx, answer = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		sy = Integer.parseInt(st.nextToken());
		sx = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken()); // 0 북 1 동 2 남 3 서
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		process(sy, sx, d);
		
		System.out.println(answer);
	}
	
	static void process(int y, int x, int dir) {
		if(map[y][x] == 0) { // 1. 현재 위치 청소
			answer++;
			map[y][x] = 2; // 청소 표시
		}
		else if(map[y][x] == 1) // 2-4. 후진했는데 벽이면 작동을 멈춤
			return;
		
		for(int i = 0; i < 4; i++) {
			dir = next[dir];
			int ny = y + dy[dir];
			int nx = x + dx[dir];
			
			if(map[ny][nx] > 0) // 2-2. 이미 청소했거나, 벽인 경우 왼쪽방향으로 회전
				continue;
			
			// 2-1. 청소하지 않은 공간이라면, 그 방향으로 한칸 전진하고 1번부터 진행
			process(ny, nx, dir);
			return;
		}
		
		// 2-3. 네 방향 모두 청소가 되어있거나 벽인 경우, 방향을 유지한 채로 한칸 후진
		process(y - dy[dir], x - dx[dir], dir);
		return;
	}
}