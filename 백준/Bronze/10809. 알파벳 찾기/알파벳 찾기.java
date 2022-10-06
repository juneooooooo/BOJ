import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringBuilder sb = new StringBuilder();
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int[] arr = new int[150];
		Arrays.fill(arr, -1);
		
		String s = sc.next();
		
		for(int i = 0; i < s.length(); i++) {
			if(arr[s.charAt(i)] == -1)
				arr[s.charAt(i)] = i;
		}
		for(int i = 'a'; i <= 'z'; i++) {
			sb.append(arr[i] + " ");
		}
		
		System.out.println(sb.toString());
	}
	
}