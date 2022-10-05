import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] prime = new int[1001];
		int answer = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr); // arr[N - 1] 이 가장 큰 수
		
		int max_num = arr[N - 1];
		int sqrt_num = (int) Math.sqrt(arr[N - 1]);
		
		for(int i = 2; i <= max_num; i++) // index로 초기화
			prime[i] = i;
		
		for(int i = 2; i <= sqrt_num; i++) { // 에라토스테네스의 체
			if(prime[i] == 0)
				continue;
			
			for(int j = i * i; j <= max_num; j += i)
				prime[j] = 0; // 소수가 아니면 0 처리
		}
		
		for(int i = 0; i < N; i++) {
			if(prime[arr[i]] != 0)
				answer++;
		}
		System.out.println(answer);
		
		//bw.flush();
		//bw.close();
		br.close();
	}
	
}