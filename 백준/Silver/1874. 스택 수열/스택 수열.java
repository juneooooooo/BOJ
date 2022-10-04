import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine()); // 숫자 개수
		int start = 0;
		Stack<Integer> stk = new Stack<>();
		
		for(int i = 0; i < n; i++) {
			int val = Integer.parseInt(br.readLine());
			
			if(val > start) {
				for(int j = start + 1; j <= val; j++) {
					stk.push(j);
					sb.append('+').append('\n');
				}
				start = val;
			}
			else if(stk.peek() != val) {
				System.out.println("NO");
				return;
			}
			stk.pop();
			sb.append('-').append('\n');;
		}
			
		br.close();
		System.out.println(sb);
	}
}