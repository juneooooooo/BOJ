import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int min = Integer.MAX_VALUE;
	static int[][] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N];
		StringTokenizer st;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++ ) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		DFS(0, 0);
		
		System.out.println(min);
		br.close();
	}
	
	static void DFS(int idx, int depth) { // N / 2 명씩 팀 나누기
		if(depth == N / 2) {
			calc();
			return;
		}
		for(int i = idx; i < N; i++) {
			visited[i] = true;
			DFS(i + 1, depth + 1);
			visited[i] = false;
		}
	}
	
	static void calc() { // 능력치 차이 계산
		int start = 0;
		int link = 0;
		
		for(int i = 0; i < N - 1; i++) {
			for(int j = i + 1; j < N; j++) {
				if(visited[i] && visited[j]) { // true끼리(start 팀), false끼리(link 팀)
					start += arr[i][j];
					start += arr[j][i];
				}
				else if(!visited[i] && !visited[j]) {
					link += arr[i][j];
					link += arr[j][i];
				}
			}
		}
		int temp = Math.abs(start - link);
		min = Math.min(min, temp);
		
		return;
	}
}