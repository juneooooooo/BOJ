import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringBuilder sb = new StringBuilder();
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int R = 0;
		String S = "";
		
		for(int i = 0; i < T; i++) {
			R = sc.nextInt();
			S = sc.next();
			StringBuilder sb = new StringBuilder();
			
			for(int j = 0; j < S.length(); j++) {
				for(int k = 0; k < R; k++) {
					sb.append(S.charAt(j));
				}
			}
			System.out.println(sb.toString());
		}
		
	}
	
}