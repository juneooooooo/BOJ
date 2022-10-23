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
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		int[] dp = new int[N + 1];
		TreeSet<Integer> answer = new TreeSet<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = i + 1; j < N; j++) {
				if(arr[i] < arr[j]) {
					dp[j] = Math.max(dp[j], dp[i] + 1);
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		int max_idx = 0;
		for(int i = 0; i < N; i++) {
			if(max < dp[i]) {
				max = dp[i];
				max_idx = i;
			}
		}
		
		System.out.println(max);
		
		int cnt = max;
		for(int i = max_idx; i >= 0; i--) {
			if(dp[i] == cnt) {
				answer.add(arr[i]);
				cnt--;
			}
		}
		
		int sz = answer.size();
		for(int i = 0; i < sz; i++)
			System.out.print(answer.pollFirst() + " ");
		
	}
	
}