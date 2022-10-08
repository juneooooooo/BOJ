import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String answer = "";
		
		if(90 <= N)
			answer = "A";
		else if(80 <= N && N < 90)
			answer = "B";
		else if(70 <= N && N < 80)
			answer = "C";
		else if(60 <= N && N < 70)
			answer = "D";
		else
			answer = "F";
		
		System.out.println(answer);
		
		//bw.flush();
		//bw.close();
		//br.close();
	}
	
}