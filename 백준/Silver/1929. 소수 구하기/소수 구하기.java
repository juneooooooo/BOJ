import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringBuilder sb = new StringBuilder();
		
		int[] prime = new int[1000001];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken()); // M 이상 N 이하 소수
		
		int max_num = N;
		int sqrt_num = (int) Math.sqrt(N);
		
		for(int i = 2; i <= max_num; i++) // index로 초기화
			prime[i] = i;
		
		for(int i = 2; i <= sqrt_num; i++) { // 에라토스테네스의 체
			if(prime[i] == 0)
				continue;
			
			for(int j = i * i; j <= max_num; j += i)
				prime[j] = 0; // 소수가 아니면 0 처리
		}
		
		for(int i = M; i <= N; i++) {
			if(prime[i] != 0)
				bw.write(Integer.toString(i) + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
}