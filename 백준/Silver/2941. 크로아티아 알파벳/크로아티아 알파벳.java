import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringBuilder sb = new StringBuilder();
		
		Scanner sc = new Scanner(System.in);
		
		String[] croa = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		String s = sc.next();
		int idx = 0;
		int answer = 0;
		while(idx < s.length()) {
			boolean flag = false;
			for(int i = 0; i < croa.length; i++) {
				if(idx + croa[i].length() <= s.length() && s.substring(idx, idx + croa[i].length()).equals(croa[i])) {
					idx += croa[i].length();
					flag = true;
					break;
				}
			}
			
			if(!flag)
				idx++;
			
			answer++;
		}
		System.out.println(answer);
	}
	
}