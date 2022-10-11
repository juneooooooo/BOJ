import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		HashSet<Integer> hs = new HashSet<>();
		
		for(int i = 0; i < 10; i++) {
			int num = Integer.parseInt(br.readLine());
			
			hs.add(num % 42);
		}
		
		System.out.println(hs.size());
		
		//bw.flush();
		//bw.close();
		br.close();
	}
}