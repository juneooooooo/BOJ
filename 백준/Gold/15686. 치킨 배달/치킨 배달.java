import java.util.*;
import java.io.*;

class node {
	int y, x;
	
	node(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Main {
	static int N, M;
	static int[][] map;
	static int min = Integer.MAX_VALUE;
	static ArrayList<node> house;
	static ArrayList<node> chi;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		house = new ArrayList<>();
		chi = new ArrayList<>();
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) { // 집
					house.add(new node(i, j));
				}
				else if(map[i][j] == 2) { // 치킨집
					chi.add(new node(i, j));
				}
			}
		}
		visited = new boolean[chi.size()];
		
		DFS(0, 0);
		
		System.out.println(min);
		
		//bw.flush();
		//bw.close();
		br.close();
	}
	
	static void DFS(int idx, int depth) { // 남길 치킨집 M개 고르기
		if(depth == M) {
			calc();
			return;
		}
		
		for(int i = idx; i < chi.size(); i++) {
			if(!visited[i]) {
				visited[i] = true;
				DFS(i + 1, depth + 1);
				visited[i] = false;
			}
		}
	}
	
	static void calc() { // 도시의 치킨거리 구하기
		int sum = 0;
		
		// visited[i] = true -> 남은 치킨집
		for(int i = 0; i < house.size(); i++) {
			int cnt = Integer.MAX_VALUE;
			int cur = 0;
			
			for(int j = 0; j < chi.size(); j++) { // 집 치킨거리 구하기
				if(visited[j]) {
					cur = Math.abs(house.get(i).y - chi.get(j).y) + Math.abs(house.get(i).x - chi.get(j).x);
					cnt = Math.min(cnt, cur);
				}
			}
			sum += cnt;
		}
		
		min = Math.min(min, sum);
	}
}