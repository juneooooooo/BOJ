import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(T-- > 0) {
			String p = br.readLine(); // 수행할 함수
			int n = Integer.parseInt(br.readLine()); // 숫자 개수
			Deque<Integer> deq = new LinkedList<>();
			
			String x = br.readLine();
			StringTokenizer st = new StringTokenizer(x.substring(1, x.length() - 1), ",");
			
			if(n == 0) {
				if(p.contains("D")) 
					sb.append("error\n");
				else
					sb.append("[]\n");
				
				continue;
			}
			
			for(int i = 0; i < n; i++) {
				deq.addLast(Integer.parseInt(st.nextToken()));
			}
			
			boolean flag = true; // true : 정방향, false : 역방향
			boolean err = false;
			
			for(int i = 0; i < p.length(); i++) {
				if(p.charAt(i) == 'D') {
					if(deq.isEmpty()) {
						sb.append("error\n");
						err = true;
						break;
					}
					else {
						if(flag) 
							deq.pollFirst();
						else
							deq.pollLast();
					}
				}
				else { // 'R'
					flag = !flag;
				}
			}
			
			if(err)
				continue;
			
			sb.append("[");
			int sz = deq.size();
			if(flag) {
				for(int i = 0; i < sz; i++) {
					sb.append(deq.pollFirst());
					if(i != sz - 1)
						sb.append(",");
				}
			}
			else{
				for(int i = 0; i < sz; i++) {
					sb.append(deq.pollLast());
					if(i != sz - 1)
						sb.append(",");
				}
			}
			sb.append("]\n");
		}
		
		System.out.println(sb);
		
		//bw.flush();
		//bw.close();
		br.close();
	}
	
}