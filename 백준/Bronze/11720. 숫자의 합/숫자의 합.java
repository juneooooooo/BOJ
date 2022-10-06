import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringBuilder sb = new StringBuilder();
		
		Scanner sc = new Scanner(System.in);
		
		int answer = 0;
		
		int N = sc.nextInt();
		String num = sc.next();
		
		for(int i = 0; i < N; i++) {
			answer += num.charAt(i) - '0';
		}
		
		System.out.println(answer);
	}
	
}