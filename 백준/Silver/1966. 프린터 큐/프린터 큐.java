import java.util.*;
import java.io.*;

class node {
	int val, idx;
	
	node(int val, int idx) {
		this.val = val;
		this.idx = idx;
	}
}

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 문서 개수
			int M = Integer.parseInt(st.nextToken()); // 현재 idx
			
			int answer = 0;
			ArrayList<Integer> vals = new ArrayList<>();
			Queue<node> q = new LinkedList<>(); // val, idx 저장
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				int val = Integer.parseInt(st.nextToken());
				vals.add(val);
				q.add(new node(val, i));
			}
				
			Collections.sort(vals, Collections.reverseOrder());
			
			while(!q.isEmpty()) {
				node n = q.poll();
				
					
				if(n.val == vals.get(0)) {// 현재 꺼낸 값이 최대값이면
					vals.remove(0);
					answer++;
					
					if(n.idx == M) {
						break;
					}
	
					continue;
				}		
		
				q.add(n);
			}
			
			sb.append(answer + "\n");
		}
		
		System.out.println(sb);
		
		//bw.flush();
		//bw.close();
		br.close();
	}
	
}