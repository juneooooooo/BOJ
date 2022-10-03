import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int[] cnt = new int[10001];
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) 
			cnt[Integer.parseInt(br.readLine())]++;
		
		br.close();
		
		for(int i = 1; i < 10001; i++) {
			if(cnt[i] > 0) {
				while(cnt[i] > 0) {
					cnt[i]--;
					sb.append(i).append('\n');
				}
			}
		}
			
		System.out.println(sb);
	}
}