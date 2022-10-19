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
	static boolean[] visited = new boolean[1000001];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		isPrime(1000000);
		
		while(true) {
			int N = Integer.parseInt(br.readLine());
			boolean flag = true;
			
			if(N == 0)
				break;
			
			for(int idx = 3; idx <= N; idx += 2) {
				if(!visited[idx] && !visited[N - idx]) {
					sb.append(N + " = " + idx + " + " + (N - idx)).append("\n");
					flag = false;
					break;
				}
			}
			if(flag)
				sb.append("Goldbach's conjecture is wrong.\n");	
		}
		
		System.out.println(sb);
	}
	
	static void isPrime(int N) {
		visited[0] = visited[1] = true; // true : 소수 X, false : 소수
		
		for(int i = 2; i <= Math.sqrt(N); i++) {
			
			if(!visited[i]) {
				
				for(int j = i * i; j <= N; j += i) {
					if(!visited[j])
						visited[j] = true;
				}
			}
		}
		
		return;
	}
}