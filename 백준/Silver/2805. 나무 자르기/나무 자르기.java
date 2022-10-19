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
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		
		long[] trees = new long[N];
		
		long max = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			trees[i] = Long.parseLong(st.nextToken());
			max = Math.max(trees[i], max);
		}
			
		long min = 0;
		long mid = 0;
		
		while(min < max) {
			mid = (max + min) / 2;
			
			long cnt = 0;
			
			for(int i = 0; i < N; i++) {
				if(trees[i] > mid)
					cnt += (trees[i] - mid);
			}
			
			if(cnt >= M) 
				min = mid + 1;
			else
				max = mid;
		}
		
		System.out.println(max - 1);
	}
	
}