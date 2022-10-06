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
		
		for(int i = 0; i < croa.length; i++) {
			s = s.replace(croa[i], "a");
		}
		
		System.out.println(s.length());
	}
	
}