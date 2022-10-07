import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String S = br.readLine();
		HashSet<String> hs = new HashSet<>();
		
		for(int i = 1; i <= S.length(); i++) {
			for(int j = 0; j <= S.length() - i; j++) {
				String cur = S.substring(j, j + i);
				hs.add(cur);
			}
		}
		
		System.out.println(hs.size());
		
		//bw.flush();
		//bw.close();
		br.close();
	}
	
}