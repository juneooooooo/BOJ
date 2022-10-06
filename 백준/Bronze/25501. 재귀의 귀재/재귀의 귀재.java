import java.util.*;
import java.io.*;

public class Main {
	static int cnt;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			cnt = 0;
			String s = br.readLine();
			
			bw.write(isPalindrome(s) + " " + cnt + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int recursion(String s, int l, int r){
        cnt++;
		if(l >= r) 
        	return 1;
        else if(s.charAt(l) != s.charAt(r)) 
        	return 0;
        else 
        	return recursion(s, l+1, r-1);
    }
	
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
	
}