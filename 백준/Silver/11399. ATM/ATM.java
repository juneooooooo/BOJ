import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		int[] times = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			times[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(times);
		
		int sum = 0;
		for(int i = 0; i < N; i++) {
			sum += times[i];
			answer += sum;
		}
		
		System.out.println(answer);
	}
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
}