import java.util.*;
import java.io.*;

/*
Arrays.sort(time, new Comparator<int[]>() {
		
		@Override
		public int compare(int[] a, int[] b) {
			if(a[1] == b[1]) { // 종료시간([1])이 같을 경우 시작시간이 빠른 순서로 정렬
				return a[0] - b[0];
			}
			
			return a[1] - b[1];
		}
	});
*/

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		long[] dist = new long[N - 1]; // 거리
		long[] cost = new long[N]; // 비용
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N - 1; i++)
			dist[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++)
			cost[i] = Integer.parseInt(st.nextToken());
		
		long sum = 0;
		long min_cost = cost[0];
		
		for(int i = 0; i < N - 1; i++) {
			if(cost[i] < min_cost) 
				min_cost = cost[i];
				
			sum += min_cost * dist[i];
		}
			
		System.out.println(sum);
	}
}