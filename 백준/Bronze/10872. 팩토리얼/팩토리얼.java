import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int answer;
	
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringBuilder sb = new StringBuilder();
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();

		if(N == 0 || N == 1)
			answer = 1;
		else
			answer = factorial(N);
		
		System.out.println(answer);
	}
	
	static int factorial(int idx) {
		if(idx == 1)
			return 1;
		
		return idx * factorial(idx - 1);
	}
	
}