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
		
		int K = Integer.parseInt(st.nextToken()); // 가지고 있는 랜선 개수
		int N = Integer.parseInt(st.nextToken()); // 필요한 랜선 개수
		
		int[] lan = new int[K];
		
		long max = 0;
		
		for(int i = 0; i < K; i++) {
			lan[i] = Integer.parseInt(br.readLine());
			max = Math.max(lan[i], max);
		}
			
		max++; // mid가 0이 나오는 경우 방지
		
		long min = 0;
		long mid = 0;
		
		while(min < max) {
			mid = (max + min) / 2;
			
			long cnt = 0;
			
			for(int i = 0; i < K; i++) {
				cnt += (lan[i] / mid);
			}
			
			if(cnt < N) 
				max = mid;
			else
				min = mid + 1;
		}
		
		System.out.println(min - 1);
	}
	
}