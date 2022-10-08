import java.util.*;
import java.io.*;

public class Main {
	
	static char[][] arr;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int num = 666;
		int answer = 1;
		
		while(answer != N) {
			num++;
			
			if(String.valueOf(num).contains("666"))
				answer++;
		}
		
		System.out.println(num);
		
		//bw.flush();
		//bw.close();
		//br.close();
	}
	
}