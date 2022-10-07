import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			if(A == 0 && B == 0)
				break;
			
			if(B % A == 0) 
				sb.append("factor\n");
			else if(A % B == 0) 
				sb.append("multiple\n");
			else
				sb.append("neither\n");
		}
		
		System.out.println(sb);
		
		//bw.flush();
		//bw.close();
		br.close();
	}
	
}