import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] map;
	static int[] result;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N];
		result = new int[N];
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		DFS(0);
		
		System.out.println(min);
		
		//bw.flush();
		//bw.close();
		br.close();
	}

	static void DFS(int depth) {
		if(depth == N) { 
			int sum = 0;
			boolean flag = true;
			
			for(int i = 0; i < N; i++) {
				int cur = result[i % N];
				int next = result[(i + 1) % N];
				
				if(map[cur][next] == 0) {
					flag = false;
					break;
				}
				
				sum += map[cur][next];
			}
			if(flag)
				min = Math.min(min, sum);
			
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[depth] = i;
				DFS(depth + 1);
				visited[i] = false;
			}
		}
	}
}