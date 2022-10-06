import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringBuilder sb = new StringBuilder();
		
		Scanner sc = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder(sc.next());
		int A = Integer.parseInt(sb.reverse().toString());
		sb = new StringBuilder(sc.next());
		int B = Integer.parseInt(sb.reverse().toString());
		
		System.out.println(A > B ? A : B);
	}
	
}