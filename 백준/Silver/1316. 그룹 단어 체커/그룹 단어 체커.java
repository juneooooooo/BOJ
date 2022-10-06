import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringBuilder sb = new StringBuilder();
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int answer = 0;
		
		for(int i = 0; i < N; i++) {
			String s = sc.next();
			boolean flag = true;
			
			for(int j = 0; j < s.length(); j++) {
				char c = s.charAt(j);
				
				if(s.indexOf(c) == s.lastIndexOf(c))
					continue;
				else {
					for(int k = s.indexOf(c); k <= s.lastIndexOf(c); k++) {
						if(s.charAt(k) != c) {
							flag = false;
							break;
						}
					}
				}
				if(!flag)
					break;
			}
			if(flag)
				answer++;
		}
		
		System.out.println(answer);
	}
	
}