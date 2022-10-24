import java.util.*;
import java.io.*;

class node {
	int s, time, clip;
	node(int s, int time, int clip) {
		this.s = s;
		this.time = time;
		this.clip = clip;
	}
}

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int S = Integer.parseInt(br.readLine());
		boolean[][] visited = new boolean[2001][2001]; // [화면][클립보드]
		Queue<node> q = new LinkedList<>();
		
		q.add(new node(1, 0, 0)); // node(s, time, clip)
		 						  // 화면, 시간, 클립보드에 저장된 개수
		
		while(!q.isEmpty()) {
			node cur = q.poll();
			
			if(cur.s == S) {
				System.out.println(cur.time);
				break;
			}
			
			if(cur.s > 0 && cur.s < 2000) {
				if(!visited[cur.s][cur.s]) { // 1. 클립보드에 저장
					visited[cur.s][cur.s] = true;
					q.add(new node(cur.s, cur.time + 1, cur.s));
				}
				
				if(!visited[cur.s - 1][cur.clip]) { // 3. 화면에서 1개 삭제
					visited[cur.s - 1][cur.clip] = true;
					q.add(new node(cur.s - 1, cur.time + 1, cur.clip));
				}
			}
			
			if(cur.clip > 0 && cur.s + cur.clip < 2000) {// 2. 클립보드에서 화면에 붙여넣기
				if(!visited[cur.s + cur.clip][cur.clip]) {
					visited[cur.s + cur.clip][cur.clip] = true; 
					q.add(new node(cur.s + cur.clip, cur.time + 1, cur.clip));
				}
			}
					
		}
		
	}
}