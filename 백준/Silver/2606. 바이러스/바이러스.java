import java.util.*;
import java.io.*;

public class Main {

	static boolean[][] map;
	static boolean[] visited;
	static int N, M;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine()); // 컴퓨터 개수
		M = Integer.parseInt(br.readLine()); // 간선 개수
		map = new boolean[N + 1][N + 1];
		visited = new boolean[N + 1]; // 방문한 vertex 체크
		
		int start = 0;
		int end = 0;
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			
			map[start][end] = map[end][start] = true;
		}
		
		DFS(1);
		
		System.out.println(answer);
	}
	
	static int DFS(int idx) {
		visited[idx] = true;
		
		for(int i = 1; i <= N; i++) {
			if(map[idx][i] && !visited[i]) {
				answer++;
				DFS(i);
			}
		}
		
		return answer;
	}
}