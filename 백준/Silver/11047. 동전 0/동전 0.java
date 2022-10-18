import java.util.*;
import java.io.*;

public class Main {
	static int N, K;
	static int[] coin;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		coin = new int[N];
		
		for(int i = 0; i < N; i++)
			coin[i] = Integer.parseInt(br.readLine());
		
		int answer = 0;
		for(int i = N - 1; i >= 0; i--) {
			if(K >= coin[i]) {
				answer += K / coin[i];
				K %= coin[i];
			}
		}
		
		System.out.println(answer);
		
	}
}