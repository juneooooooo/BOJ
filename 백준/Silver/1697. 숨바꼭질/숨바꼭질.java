import java.util.*;
import java.io.*;

public class Main {
	static int N, K;
	static int visited[] = new int[100001];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		BFS(N);
		
		System.out.println(visited[K] - 1);
		
		//bw.flush();
		//bw.close();
		br.close();
	}
	
	static void BFS(int n) {
		Queue<Integer> q = new LinkedList<>();
		
		visited[n] = 1; // 처음 위치가 1초이므로 마지막 위치 - 1이 걸린 시간
		q.add(n);       // 처음 위치를 0으로 하고 0이면 방문 X로 처리하면 겹치므로 
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(cur == K) {
				return;
			}
			
			if(0 <= cur - 1 && visited[cur - 1] == 0) {
				visited[cur - 1] = visited[cur] + 1;
				q.add(cur - 1);
			}
			if(cur + 1 <= 100000 && visited[cur + 1] == 0) {
				visited[cur + 1] = visited[cur] + 1;
				q.add(cur + 1);
			}
			if(2 * cur <= 100000 && visited[2 * cur] == 0) {
				visited[2 * cur] = visited[cur] + 1;
				q.add(2 * cur);
			}
		}
	}
}