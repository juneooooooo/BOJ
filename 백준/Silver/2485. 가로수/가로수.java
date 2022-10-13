import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dist = new int[N - 1];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 1; i < N; i++) { // 현재 심어져있는 가로수들간의 거리 구하기
			dist[i - 1] = arr[i] - arr[i - 1];
		}
		
		int gcd = GCD(dist[0], dist[1]);
		for(int i = 1; i < N - 1; i++) {
			gcd = GCD(gcd, dist[i]);
		}
		
		int answer = 0;
		for(int i = 0; i < N - 1; i++) {
			answer += (dist[i] / gcd) - 1;
		}
		
		System.out.println(answer);
		
		//bw.flush();
		//bw.close();
		br.close();
	}
	
	static int GCD(int a, int b) {
		int max = Math.max(a,  b);
		int min = Math.min(a,  b);
		
		while(min > 0) {
			int temp = max % min;
			max = min;
			min = temp;
		}
		return max;
	}

}