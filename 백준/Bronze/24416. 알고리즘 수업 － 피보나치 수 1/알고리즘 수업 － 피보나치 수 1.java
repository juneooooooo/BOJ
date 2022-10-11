import java.util.*;
import java.io.*;

public class Main {
	static int fib_cnt = 0;
	static int fibonacci_cnt = 0;
	static int N;
	static int[] f;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		f = new int[N + 1];
		
		fib(N);
		fibonacci(N);
		
		System.out.println(fib_cnt + " " + fibonacci_cnt);
		
		//bw.flush();
		//bw.close();
		br.close();
	}
	
	static int fib(int n) {
		if(n == 1 || n == 2) {
			fib_cnt++;
			return 1;
		}
		else 
			return fib(n - 1) + fib(n - 2);
	}
	
	static int fibonacci(int n) {
		f[1] = f[2] = 1;
		for(int i = 3; i <= n; i++) {
			fibonacci_cnt++;
			f[i] = f[i - 1] + f[i - 2];
		}
		return f[n];
	}
}