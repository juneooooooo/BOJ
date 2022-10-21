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
	static boolean[] buttons = new boolean[10];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 목표
		int M = Integer.parseInt(br.readLine()); // 고장난 버튼 개수
		Arrays.fill(buttons, true);
		
		StringTokenizer st = null;
		if(M != 0) {
			st = new StringTokenizer(br.readLine());
		}
			
		for(int i = 0; i < M; i++) {
			int idx = Integer.parseInt(st.nextToken());
			
			buttons[idx] = false;
		}
		
		if(N == 100) {
			System.out.println(0);
			System.exit(0);
		}
		
		int answer = Math.abs(N - 100); // 버튼 최대 누르는 횟수
		
		for(int i = 0; i <= 1000000; i++) {
			String s = String.valueOf(i);
			
			if(isCorrect(s)) {
				int cnt = s.length() + Math.abs(i - N);
				answer = Math.min(answer, cnt);
			}
		}
		
		System.out.println(answer);
	}
	
	static boolean isCorrect(String s) { // 리모콘으로 누를 수 있는 숫자인지?
		for(int i = 0; i < s.length(); i++) {
			int idx = s.charAt(i) - '0';
			
			if(!buttons[idx])
				return false;
		}
		return true;
	}
	
}