import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int answer;
	static int fibo[];
	
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringBuilder sb = new StringBuilder();
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		System.out.println(fi(N));
	}
	
	static int fi(int idx) {
		if(idx == 0)
			return 0;
		else if(idx == 1 || idx == 2)
			return 1;
		
		return fi(idx - 1) + fi(idx - 2);
	}
	
}