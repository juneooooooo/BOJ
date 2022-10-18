import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[][] time = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(time, new Comparator<int[]>() {
			
			@Override
			public int compare(int[] a, int[] b) {
				if(a[1] == b[1]) { // 종료시간([1])이 같을 경우 시작시간이 빠른 순서로 정렬
					return a[0] - b[0];
				}
				
				return a[1] - b[1];
			}
		});
		
		int answer = 0;
		int end_time = 0;
		for(int i = 0; i < N; i++) {
			if(end_time <= time[i][0]) { // 전 회의 종료시간이 다음 회의 시작시간보다 작은 경우
				end_time = time[i][1];
				answer++;
			}
		}
		
		System.out.println(answer);
	}
}