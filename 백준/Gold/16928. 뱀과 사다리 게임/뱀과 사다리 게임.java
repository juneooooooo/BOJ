import java.util.*;
import java.io.*;

public class Main {
	static int M, N;
	static int[] map = new int[101];
	static int[] visited = new int[101];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 사다리
		M = Integer.parseInt(st.nextToken()); // 뱀
		
		for(int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			map[u] = v;
		}
		
		BFS(1);
		
		System.out.println(visited[100] - 1);
		
		//bw.flush();
		//bw.close();
		br.close();
	}
	
	static void BFS(int now) {
		Queue<Integer> q = new LinkedList<>();
		q.add(now);
		visited[now] = 1;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(cur == 100) 
				return;
			
			for(int i = 1; i <= 6; i++) {
				int next = cur + i;
				
				if(next > 100)
					continue;
				
				if(visited[next] != 0)
					continue;
				
				if(map[next] != 0) { // 사다리 or 뱀이 있는 경우
					if(visited[map[next]] == 0) {
						q.add(map[next]);
						//visited[next] = visited[cur] + 1;
						visited[map[next]] = visited[cur] + 1;
					}
				}
				else {
					q.add(next);
					visited[next] = visited[cur] + 1;
				}
			}
		}
	}
}