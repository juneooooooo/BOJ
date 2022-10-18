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
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i < N; i++) {
			int num = gcd(arr[0], arr[i]);
			
			sb.append(arr[0] / num + "/" + arr[i] / num + "\n");
		}
		
		System.out.println(sb);
	}
	
	static int gcd(int a, int b) {
		if(a % b == 0) {
			return b;
		}
		else {
			return gcd(b, a % b);
		}
	}
}