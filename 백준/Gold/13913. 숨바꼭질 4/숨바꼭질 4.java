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
		int[] parent = new int[100_001]; // 이 전에 있었던 위치 저장
		
		while(!q.isEmpty()) {
			node cur = q.poll();
			
			if(cur.idx == K) {
				min = cur.time;
				break;
			}
			
			if(2*cur.idx <= 100_000 && !visited[2*cur.idx]) {
				q.add(new node(2*cur.idx, cur.time + 1));
				visited[2*cur.idx] = true;
				parent[2*cur.idx] = cur.idx;
			}
			
			if(cur.idx - 1 >= 0 && !visited[cur.idx - 1]) {
				q.add(new node(cur.idx - 1, cur.time + 1));
				visited[cur.idx - 1] = true;
				parent[cur.idx - 1] = cur.idx;
			}
			
			if(cur.idx + 1 <= 100_000 && !visited[cur.idx + 1]) {
				q.add(new node(cur.idx + 1, cur.time + 1));
				visited[cur.idx + 1] = true;
				parent[cur.idx + 1] = cur.idx;
			}
		}
		
		Stack<Integer> stk = new Stack<>();
		
		stk.push(K);
		int idx = K;
		
		while(idx != N) {
			stk.push(parent[idx]);
			idx = parent[idx];
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(min).append("\n");
		while(!stk.isEmpty()) {
			sb.append(stk.pop() + " ");
		}
		System.out.println(sb);
	}
	
}