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
		
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		
		int answer = Integer.MAX_VALUE;
		
		while(st.hasMoreTokens()) {
			StringTokenizer oper = new StringTokenizer(st.nextToken(), "+");
			
			int temp = 0;
			
			while(oper.hasMoreTokens()) {
				temp += Integer.parseInt(oper.nextToken());
			}
			
			if(answer == Integer.MAX_VALUE)
				answer = temp;
			else
				answer -= temp;
		}
		
		System.out.println(answer);
	}
}