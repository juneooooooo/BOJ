import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] arr;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int plus = Integer.parseInt(st.nextToken());
		int minus = Integer.parseInt(st.nextToken());
		int mul = Integer.parseInt(st.nextToken());
		int div = Integer.parseInt(st.nextToken());
		
		operation(1, arr[0], plus, minus, mul, div);
		
		System.out.println(max + "\n" + min);
		//bw.flush();
		//bw.close();
		br.close();
	}
	
	static void operation(int idx, int sum, int plus, int minus, int mul, int div) {
		if(idx == N) {
			max = Math.max(sum, max);
			min = Math.min(sum, min);
			return;
		}
		
		if(plus > 0)
			operation(idx + 1, sum + arr[idx], plus - 1, minus, mul, div);
		if(minus > 0)
			operation(idx + 1, sum - arr[idx], plus, minus - 1, mul, div);
		if(mul > 0)
			operation(idx + 1, sum * arr[idx], plus, minus, mul - 1, div);
		if(div > 0)
			operation(idx + 1, sum / arr[idx], plus, minus, mul, div - 1);
	}
}