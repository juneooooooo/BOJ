import java.util.*;
import java.io.*;

/*
Arrays.sort(time, new Comparator<int[]>() {
		
		@Override
		public int compare(int[] a, int[] b) {
			if(a[1] == b[1]) {
				return a[0] - b[0];
			}
			
			return a[1] - b[1];
		}
	}); //  [두 수의 비교 결과에 따른 작동 방식]
		//	음수일 경우 : 두 원소의 위치를 교환 안함
		//	양수일 경우 : 두 원소의 위치를 교환 함
*/

public class Main {
	
	static int N, M, K, cnt;
	static boolean[][] map, visited;
	static int[] dy = {-1, 1, 0, 0}; // 상, 하, 좌, 우
	static int[] dx = {0, 0, -1, 1};
	static ArrayList<Integer> al = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // y
		N = Integer.parseInt(st.nextToken()); // x
		K = Integer.parseInt(st.nextToken());
		map = new boolean[M][N];
		int answer = 0;
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int nx = Integer.parseInt(st.nextToken());
			int ny = Integer.parseInt(st.nextToken());
			
			for(int j = y; j < ny; j++) {
				for(int k = x; k < nx; k++) {
					map[j][k] = true;
				}
			}
		}
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(!map[i][j]) {
					cnt = 0;
					
					DFS(i, j);
					answer++;
				
					al.add(cnt);
				}
			}
		}
		
		Collections.sort(al);
		StringBuilder sb = new StringBuilder();
		
		sb.append(answer).append("\n");
		for(int i = 0; i < al.size(); i++)
			sb.append(al.get(i) + " ");
		
		System.out.println(sb);
	}
	
	static void DFS(int y, int x) {
		map[y][x] = true;
		cnt++;
		
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny < 0 || ny >= M || nx < 0 || nx >= N)
				continue;
			
			if(!map[ny][nx]) 
				DFS(ny, nx);
		}
	}
	
}