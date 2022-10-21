import java.util.*;
import java.io.*;

/*
Arrays.sort(time, new Comparator<int[]>() {
		
		@Override
		public int compare(int[] a, int[] b) {
			if(a[1] == b[1]) {
				return a[0] - b[0];
			}
			
			return a[1] - b[1];
		}
	}); //  [두 수의 비교 결과에 따른 작동 방식]
		//	음수일 경우 : 두 원소의 위치를 교환 안함
		//	양수일 경우 : 두 원소의 위치를 교환 함
*/

public class Main {
	static int[] arr;
	static boolean[] visited;
	static int N, M;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		visited = new boolean[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		DFS(1, 0);
	}
	
	static void DFS(int idx, int depth) {
		if(depth == M) {
			for(int i = 1; i <= N; i++) {
				if(visited[i])
					System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
		
		for(int i = idx; i <= N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				DFS(i + 1, depth + 1);
				visited[i] = false;
			}
		}
	}
}