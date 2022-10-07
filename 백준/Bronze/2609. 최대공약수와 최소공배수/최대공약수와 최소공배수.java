import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
			
		int a = A;
		int b = B;
		int c = A % B;
		while(c > 0) {
			a = b;
			b = c; // 최대공약수
			c = a % b;
		}
		
		System.out.println(b + "\n" + A*B/b);
		
		//bw.flush();
		//bw.close();
		br.close();
	}
	
}