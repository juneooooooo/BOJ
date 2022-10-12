import java.util.*;
import java.io.*;

public class Main {
	static int N, cnt;
	static boolean[] visited;
	static String answer;
	static char[] chars;
	static int[] factorial = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 3628800, 3628880};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String l = "";
		
		while((l = br.readLine()) != null) { 
			StringTokenizer st = new StringTokenizer(l);
			
			String s = st.nextToken();
			N = Integer.parseInt(st.nextToken());
			visited = new boolean[s.length()];
			cnt = 0;
			chars = new char[s.length()];
			
			if(factorial[s.length()] < N)
				answer = "No permutation";
			else
				DFS(s, 0);
			
			System.out.println(s + " " + N + " = " + answer);
		}
		
		//bw.flush();
		//bw.close();
		br.close();
	}

	static void DFS(String s, int depth) {
		if(depth == s.length()) {
			cnt++;
			if(cnt == N) {
				answer = new String(chars);
			}
			return;
		}
		
		for(int i = 0; i < s.length(); i++) {
			if(!visited[i]) {
				visited[i] = true;
				chars[depth] = s.charAt(i);
				DFS(s, depth + 1);
				visited[i] = false;
			}
		}
	}
}