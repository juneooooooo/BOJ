import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int first = 1;
		int last = 1;
		int six_cnt = 0;
		
		while(true) {
			
			if(first <= N && N <= last + (six_cnt * 6))
				break;
			
			first = last + (six_cnt * 6) + 1;
			last += six_cnt * 6;
			six_cnt++;
		}
		
		System.out.println(six_cnt + 1);
		
		//bw.flush();
		//bw.close();
		//br.close();
	}
	
}