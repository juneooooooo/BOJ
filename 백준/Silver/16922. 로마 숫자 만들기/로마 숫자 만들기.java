import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] num = {1, 5, 10, 50};
	static int[] result;
	static boolean[] visited; // 50 * 20이 최대
	static int answer = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		result = new int[N];
		visited = new boolean[(N * 50) + 1];
		DFS(0, 0, 0);
		
		System.out.println(answer);
		
		//bw.flush();
		//bw.close();
		br.close();
	}
	
	static void DFS(int idx, int depth, int sum) {
		if(depth == N) {
			if(!visited[sum]) {
				answer++;
				visited[sum] = true;
			}
			
			return;
		}
		
		for(int i = idx; i < 4; i++) {
			DFS(i, depth + 1, sum + num[i]);
		}
	}
	
}