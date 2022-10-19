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
		
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int x = Integer.parseInt(br.readLine());
		
		int start = 0;
		int end = n - 1;
		int sum = 0;
		
		Arrays.sort(arr); // 1 2 3 5 7 9 10 11 12
		
		while(start < end) {
			sum = arr[start] + arr[end];
			
			if(sum == x)
				answer++;
			
			if(sum <= x)
				start++;
			else
				end--;
		}
		
		System.out.println(answer);
	}
	
}