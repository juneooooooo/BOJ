import java.util.*;
import java.io.*;

public class Main {
	static int N, K;
	static int answer = 0;
	static int[] arr;
	static boolean[] visited;
	static int[] result;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // nPn
		K = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		visited = new boolean[N + 1];
		result = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		DFS(0);
		
		System.out.println(answer);
		
		//bw.flush();
		//bw.close();
		br.close();
	}
	
	static void DFS(int depth) {
		if(depth == N) {
			boolean flag = true;
			int sum = 500;
			
			for(int i = 0; i < N; i++) {
				sum = sum - K + result[i];
				if(sum < 500) {
					flag = false;
					break;
				}
			}
			
			if(flag)
				answer++;
			
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[depth] = arr[i];
				DFS(depth + 1);
				visited[i] = false;
			}
		}
	}
	
}