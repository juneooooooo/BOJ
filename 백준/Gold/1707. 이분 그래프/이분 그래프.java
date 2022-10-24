import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int K = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
	
		while(K-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken()); // 정점
			int E = Integer.parseInt(st.nextToken()); // 간선
			ArrayList<Integer>[] map = new ArrayList[V + 1];
			for(int i = 1; i <= V; i++)
				map[i] = new ArrayList<>();
			
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				
				map[u].add(v);
				map[v].add(u);
			}
			
			boolean flag = true;
			int[] color = new int[V + 1];
			Queue<Integer> q = new LinkedList<>();
			
			for(int i = 1; i <= V; i++) {
				if(color[i] == 0) {
					q.add(i);
					color[i] = 1;
					
					while(!q.isEmpty() && flag) {
						int cur = q.poll();
						
						for(int next : map[cur]) {
							if(color[next] == 0) {
								q.add(next);
								color[next] = color[cur] * -1;
							}
							else if(color[next] == color[cur]) {
								flag = false;
								break;
							}
						}
					}
				}
			}
			sb.append(flag ? "YES\n" : "NO\n");
		}
		
		System.out.println(sb);
	}
}