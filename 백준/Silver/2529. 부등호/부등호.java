import java.util.*;
import java.io.*;

public class Main {
	static int k;
	static boolean[] visited;
	static char[] oper;
	static ArrayList<String> al = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		k = Integer.parseInt(br.readLine());
		
		oper = new char[k];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < k; i++)
			oper[i] = st.nextToken().charAt(0);
		
		visited = new boolean[10];
		
		for(int i = 0; i < 10; i++) {
			visited[i] = true;
			DFS(0, i, i + "");
			visited[i] = false;
		}
		
		Collections.sort(al);
		
		System.out.println(al.get(al.size() - 1));
		System.out.println(al.get(0));
		
		//bw.flush();
		//bw.close();
		br.close();
	}
	
	static void DFS(int depth, int prev, String s) {
		if(depth == k) {
			al.add(s);
			return;
		}
		
		for(int i = 0; i < 10; i++) {
			if(visited[i])
				continue;
			
			char tmp = oper[depth];
			
			if(tmp == '>') {
				if(prev > i) {
					visited[i] = true;
					DFS(depth + 1, i, s + i);
					visited[i] = false;
				}
			}
			else { // '<'
				if(prev < i) {
					visited[i] = true;
					DFS(depth + 1, i, s + i);
					visited[i] = false;
				}
			}
		}
	}
	
}