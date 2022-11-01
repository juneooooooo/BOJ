import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] video;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		video = new int[N];
		int left = 0, right = 0, answer = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			video[i] = Integer.parseInt(st.nextToken());
			right += video[i];
			left = Math.max(left, video[i]);
		}
		
		int mid = 0;
		while(left <= right) {
			mid = (left + right) / 2;
			
			if(check(mid)) {
				answer = mid;
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		
		System.out.println(answer);
	}
	
	private static boolean check(int mid) { // mid 크기로 M개로 나뉘어지는지 확인
		int cnt = 0, sum = 0;
		
		for(int i = 0; i < N; i++) {
			if(sum + video[i] > mid) {
				cnt++;
				sum = video[i];
			}
			else {
				sum += video[i];
			}
		}
		
		return cnt >= M ? false : true;
	}
	
}