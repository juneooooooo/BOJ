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
	static int N, M;
	static int[][] paper;
	static boolean[][] visited;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		paper = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				paper[i][j] = s.charAt(j) - '0';
			}
		}
		
		DFS(0, 0);
		
		System.out.println(max);
	}
	
	static void DFS(int y, int x) {
		if(y >= N) {
			calc();
			return;
		}
		else if(x >= M) {
			DFS(y + 1, 0);
			return;
		}
		
		visited[y][x] = true; // 가로
		DFS(y, x + 1);
		visited[y][x] = false; // 세로
		DFS(y, x + 1);
	}
	
	static void calc() {
		int sum = 0;
		int temp = 0;
		
		for(int i = 0; i < N; i++) {
			temp = 0;
			for(int j = 0; j < M; j++) {
				if(visited[i][j]) { // 가로 -> visited : true
					temp *= 10;
					temp += paper[i][j];
				}
				else {
					sum += temp;
					temp = 0;
				}
			}
			sum += temp;
		}
		
		for(int i = 0; i < M; i++) {
			temp = 0;
			for(int j = 0; j < N; j++) {
				if(!visited[j][i]) { // 세로 -> visited : false
					temp *= 10;
					temp += paper[j][i];
				}
				else {
					sum += temp;
					temp = 0;
				}
			}
			sum += temp;
		}
		
		max = Math.max(max, sum);
	}
}