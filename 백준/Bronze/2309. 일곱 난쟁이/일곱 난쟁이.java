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
	static int[] arr, result;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[9];
		result = new int[7];
		visited = new boolean[9];
		
		for(int i = 0; i < 9; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		
		DFS(0, 0, 0);
	}
	
	static void DFS(int idx, int depth, int sum) {
		if(depth == 7) {
			if(sum == 100) {
				for(int i = 0; i < 7; i++)
					System.out.println(result[i]);
				
				System.exit(0);
			}
			return;
		}
		
		for(int i = idx; i < 9; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[depth] = arr[i];
				DFS(idx + 1, depth + 1, sum + arr[i]);
				visited[i] = false;
			}
		}
	}
	
}