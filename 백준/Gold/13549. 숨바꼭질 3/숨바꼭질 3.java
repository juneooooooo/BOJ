import java.util.*;
import java.io.*;

class node {
	int idx, time;
	node(int idx, int time) {
		this.idx = idx;
		this.time = time;
	}
}

public class Main {
	static int N, K;
	static int min = 0;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Queue<node> q = new LinkedList<>();
		visited = new boolean[100_007];
		
		q.add(new node(N, 0)); // node(idx, time)
		visited[N] = true;
		
		while(!q.isEmpty()) {
			node cur = q.poll();
			
			if(cur.idx == K) {
				min = cur.time;
				break;
			}
			
			if(2*cur.idx <= 100_000 && !visited[2*cur.idx]) {
				q.add(new node(2*cur.idx, cur.time));
				visited[2*cur.idx] = true;
			}
			
			if(cur.idx - 1 >= 0 && !visited[cur.idx - 1]) {
				q.add(new node(cur.idx - 1, cur.time + 1));
				visited[cur.idx - 1] = true;
			}
			
			if(cur.idx + 1 <= 100_000 && !visited[cur.idx + 1]) {
				q.add(new node(cur.idx + 1, cur.time + 1));
				visited[cur.idx + 1] = true;
			}
			
		}
		
		System.out.println(min);
	}
	
	
}