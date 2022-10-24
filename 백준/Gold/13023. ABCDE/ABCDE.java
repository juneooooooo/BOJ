import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] map;
	static boolean[] visited;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new ArrayList[N];
		for(int i = 0; i < N; i++)
			map[i] = new ArrayList<>();
		visited = new boolean[N];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			map[u].add(v);
			map[v].add(u);
		}
		
		for(int i = 0; i < N; i++) {
			DFS(1, i);
			if(answer == 1) 
				break;
			//System.out.println();
			//System.out.println();
		}
		
		System.out.println(answer);
	}
	
	static void DFS(int depth, int idx) {
		//System.out.println(idx + " " + depth);
		
		if(depth == 5) {
			answer = 1;
			return;
		}
		
		visited[idx] = true;
		for(int next : map[idx]) {
			if(!visited[next])
				DFS(depth + 1, next);
		}
		visited[idx] = false;
	}
}