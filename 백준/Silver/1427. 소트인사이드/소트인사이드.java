import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringBuilder sb = new StringBuilder();
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> al = new ArrayList<>();
		
		String s = sc.next();
		for(int i = 0; i < s.length(); i++) {
			al.add(s.charAt(i) - '0');
		}
		Collections.sort(al, Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < s.length(); i++)
			sb.append(al.get(i));
		
		System.out.println(sb);
	}
	
}