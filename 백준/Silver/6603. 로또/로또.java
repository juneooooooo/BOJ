import java.util.*;
import java.io.*;

public class Main {
	static int[] S;
	static boolean[] visited;
	static int k;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k == 0)
				break;
			
			S = new int[k];
			visited = new boolean[k];
			
			for(int i = 0; i < k; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			DFS(0, 0);
			System.out.println();
		}
		br.close();

	}
	
	static void DFS(int idx, int depth) {
		if(depth == 6) {
			for(int i = 0; i < k; i++) {
				if(visited[i]) {
					System.out.print(S[i] + " ");
				}
			}
			System.out.println();
		}
		
		for(int i = idx; i < k; i++) {
			visited[i] = true;
			DFS(i + 1, depth + 1);
			visited[i] = false;
		}
	}
}