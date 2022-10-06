import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int max = -1;
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		DFS(0, 0);
		
		System.out.println(max);
		
		//bw.flush();
		//bw.close();
		br.close();
	}
	
	static void DFS(int idx, int depth) {
		if(depth == 3) {
			calc();
			return;
		}
		
		for(int i = idx; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				DFS(idx + 1, depth + 1);
				visited[i] = false;
			}
		}
	}
	static void calc() {
		int sum = 0;
		for(int i = 0; i < N; i++) {
			if(visited[i])
				sum += arr[i];
		}
		if(max < sum && sum <= M)
			max = sum;
	}
}