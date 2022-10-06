import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringBuilder sb = new StringBuilder();
		
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int[] arr = new int[26];
		
		for(int i = 0; i < s.length(); i++) {
			if('A' <= s.charAt(i) && s.charAt(i) <= 'Z')
				arr[s.charAt(i) - 'A']++;
			else
				arr[s.charAt(i) - 'a']++;
		}
		
		int max = -1;
		char answer = '?';
		
		for(int i = 0; i < 26; i++) {
			if(arr[i] > max) {
				max = arr[i];
				answer = (char) (i + 65);
			}
			else if(arr[i] == max) {
				answer = '?';
			}
		}
		System.out.println(answer);
	}
	
}