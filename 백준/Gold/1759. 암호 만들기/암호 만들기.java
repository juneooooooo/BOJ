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
	static int L, C, mo_cnt, ja_cnt;
	static boolean[] visited;
	static char[] letters;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		visited = new boolean[C]; // 선택된 문자 check
		letters = new char[C];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < C; i++) {
			letters[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(letters);
		
		DFS(0, 0, 0, 0);
	}
	
	static boolean isMo(char c) { // c가 모음인지?
		if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
			return true;
		
		return false;
	}
	
	static void DFS(int depth, int idx, int mo, int ja) {
		if(depth == L && mo >= 1 && ja >= 2) {
			for(int i = 0; i < C; i++) {
				if(visited[i])
					System.out.print(letters[i] + "");
			}
			System.out.println();
			
			return;
		}
		
		for(int i = idx; i < C; i++) {
			visited[i] = true;
			
			if(isMo(letters[i]))
				DFS(depth + 1, i + 1, mo + 1, ja);
			else
				DFS(depth + 1, i + 1, mo, ja + 1);
			
			visited[i] = false;
		}
	}
}