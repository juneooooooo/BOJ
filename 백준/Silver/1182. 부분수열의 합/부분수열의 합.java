import java.util.*;
import java.io.*;

public class Main {
	static int N, S, answer;
	static int[] num;
	static boolean[] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		num = new int[N]; // 모든 정수
		visited = new boolean[N];
		answer = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			num[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= N; i++) {
			DFS(0, 0, i); // 원소 1개 ~ N개 부분수열 구하기
		}
		System.out.println(answer);
		
		//bw.flush();
		//bw.close();
		br.close();
	}
	
	static void DFS(int idx, int depth, int max_depth) {
		if(depth == max_depth) {
			int sum = 0;
			for(int i = 0; i < N; i++) {
				if(visited[i]) {
					sum += num[i];
				}
			}
			if(sum == S)
				answer++;
			
			return;	
		}
		
		for(int i = idx; i < N; i++) {
			visited[i] = true;
			DFS(i + 1, depth + 1, max_depth);
			visited[i] = false;
		}
	}
}