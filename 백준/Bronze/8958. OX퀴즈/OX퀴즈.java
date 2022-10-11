import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			
			int cnt = 1;
			for(int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == 'O') {
					sum += cnt++;
				}
				else
					cnt = 1;
			}
			sb.append(sum).append("\n");
			sum = 0;
		}
		System.out.println(sb);
		//bw.flush();
		//bw.close();
		br.close();
	}
}