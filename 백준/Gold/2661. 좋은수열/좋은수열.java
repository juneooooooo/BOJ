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
	static int min = Integer.MAX_VALUE;
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		DFS(0, "");
	}
	
	public static void DFS(int depth, String s) {
		if(depth == N) {
			System.out.println(s);
			System.exit(0);
		}
		
		for(int i = 1; i <= 3; i++) {
			if(isCorrect(s + i))	
				DFS(depth + 1, s + i);
		}
	}
	
	public static boolean isCorrect(String s) {
		int len = s.length();
		
		// 마지막부터 i자리 숫자와 그 앞에 i자리 숫자가 동일한지 확인
		for(int i = 1; i <= len/2; i++) {
			String front = s.substring(len - 2*i, len - i);
			String back = s.substring(len - i, len);
			
			if(front.equals(back))
				return false;
		}
		
		return true;
	}
	
}