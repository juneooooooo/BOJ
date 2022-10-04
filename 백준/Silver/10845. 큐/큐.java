import java.util.*;
import java.io.*;
public class Main {
	static int[] q;
	static int first, last;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); // 명령의 수
		q = new int[N];
		first = last = 0;
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); // 명령 읽기
			
			switch(st.nextToken()) {
				
			case "push" : 
				push(Integer.parseInt(st.nextToken()));
				break;
			
			case "pop" :
				sb.append(pop()).append('\n');
				break;
				
			case "size" :
				sb.append(size()).append('\n');
				break;
				
			case "empty" :
				sb.append(empty()).append('\n');
				break;
				
			case "front" :
				sb.append(front()).append('\n');
				break;
				
			case "back" :
				sb.append(back()).append('\n');
				break;
			}
		}
		
		br.close();	
		
		System.out.println(sb);
	}
	
	static void push(int n) {
		q[last] = n;
		last++;
	}
	
	static int pop() {
		if(last - first == 0)
			return -1;
		
		int tmp = q[first];
		q[first] = 0;
		first++;
		return tmp;
	}
	
	static int size() {
		return last - first;
	}
	
	static int empty() {
		return last - first > 0 ? 0 : 1;
	}
	
	static int front() {
		if(last - first == 0)
			return -1;
		
		return q[first];
	}
	
	static int back() {
		if(last - first == 0)
			return -1;
		
		return q[last - 1];
	}
}