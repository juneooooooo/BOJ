import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringBuilder sb = new StringBuilder();
		
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		int answer = 0;
		if(B == C)
			answer = -1;
		else if(((-1 * A) / (B - C)) < 0)
			answer = -1;
		else
			answer = ((-1 * A) / (B - C)) + 1;
		
		System.out.println(answer);
		
	}
	
}