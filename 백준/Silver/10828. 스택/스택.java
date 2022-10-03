import java.util.*;
import java.io.*;
public class Main {
	static int[] stk;
	static int size = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); // 명령의 수
		stk = new int[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 명령 읽기
			
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
				
			case "top" :
				sb.append(top()).append('\n');
				break;
			}
		}
		
		br.close();	
		
		System.out.println(sb);
	}
	
	static void push(int n) {
		stk[size] = n;
		size++;
	}
	
	static int pop() {
		if(size == 0)
			return -1;
		
		int tmp = stk[size - 1];
		stk[size - 1] = 0;
		size--;
		return tmp;
	}
	
	static int size() {
		return size;
	}
	
	static int empty() {
		return size > 0 ? 0 : 1;
	}
	
	static int top() {
		if(size == 0)
			return -1;
		
		return stk[size - 1];
	}
}