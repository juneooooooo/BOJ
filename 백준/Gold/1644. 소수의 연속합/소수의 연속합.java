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
	static boolean[] visited;
	static int N;
	static ArrayList<Integer> pNum = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N + 1];
		
		if(N == 1) {
			System.out.println(0);
			System.exit(0);
		}
		
		isPrime();
		
		int answer = 0;
		int start = 0;
		int end = 0;
		int sum = 0;
		
		while(start <= end && end < pNum.size()) {
			sum = getSum(start, end);
			
			if(sum == N)
				answer++;
			
			if(sum < N) 
				end++;
			else
				start++;
		}
		
		System.out.println(answer);
	}
	
	public static void isPrime() { // 소수 구하기
		visited[0] = visited[1] = true; // false : 소수, true : 소수 X
		
		for(int i = 2; i <= Math.sqrt(N); i++) {
			
			if(!visited[i]) {
				for(int j = i * i; j <= N; j += i) {
					visited[j] = true;
				}
			}
		}
		
		for(int i = 2; i <= N; i++) {
			if(!visited[i])
				pNum.add(i);
		}
		
		return;
	}
	
	public static int getSum(int start, int end) {
		int sum = 0;
		for(int i = start; i <= end; i++)
			sum += pNum.get(i);
		
		return sum;
	}
}