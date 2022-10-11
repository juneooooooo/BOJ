import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] arr = new int[9];
		int max = -1;
		int max_idx = -1;
		
		for(int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			
			max = Math.max(arr[i], max);
			if(max == arr[i])
				max_idx = i + 1;
		}
		
		System.out.println(max + "\n" + max_idx);
		
		//bw.flush();
		//bw.close();
		br.close();
	}
}