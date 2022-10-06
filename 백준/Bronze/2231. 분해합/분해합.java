import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		
		for(int i = 1; i < N; i++) {
			int cur = i;
			int sum = i;
			while(cur > 0) {
				sum += cur % 10;
				cur /= 10;
			}
			if(sum == N) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
		//bw.flush();
		//bw.close();
		br.close();
	}
	
}