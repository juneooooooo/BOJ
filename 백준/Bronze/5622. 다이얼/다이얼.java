import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringBuilder sb = new StringBuilder();
		
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		int answer = 0;
		
		for(int i = 0; i < s.length(); i++) {
			answer += calc(s.charAt(i));
		}
		
		System.out.println(answer);
	}
	
	static int calc(char c) {
		int num = 2;
		
		if('A' <= c && c <= 'C')
			num += 1;
		else if('D' <= c && c <= 'F')
			num += 2;
		else if('G' <= c && c <= 'I')
			num += 3;
		else if('J' <= c && c <= 'L')
			num += 4;
		else if('M' <= c && c <= 'O')
			num += 5;
		else if('P' <= c && c <= 'S')
			num += 6;
		else if('T' <= c && c <= 'V')
			num += 7;
		else if('W' <= c && c <= 'Z')
			num += 8;
		
		return num;
	}
	
}