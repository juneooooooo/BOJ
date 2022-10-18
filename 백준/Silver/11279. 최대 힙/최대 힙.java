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
		
		PriorityQueue<Long> pq = new PriorityQueue<>();
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			long x = Long.parseLong(br.readLine());
			
			if(x == 0) {
				if(pq.isEmpty())
					sb.append(0).append("\n");
				else
					sb.append(-pq.poll()).append("\n");
			}
			else {
				pq.add(-x);
			}
		}
		
		System.out.println(sb);
	}

}