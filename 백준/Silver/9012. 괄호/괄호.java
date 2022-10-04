import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			Stack<Character> stk = new Stack<>();
			boolean flag = true;
			for(int j = 0; j < s.length(); j++) {
				if(s.charAt(j) == '(') {
					stk.push('(');
				}
				else {
					if(stk.size() != 0 && stk.pop() == '(') {
						continue;
					}
					else {
						flag = false;
						break;
					}
				}
			}
			if(stk.size() == 0 && flag) 
				bw.write("YES\n");
			else
				bw.write("NO\n");
		}
			
		bw.flush();
		br.close();
		bw.close();
	}

}