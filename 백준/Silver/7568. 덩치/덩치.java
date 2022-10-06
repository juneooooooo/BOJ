import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[][] dung = new int[N][2];
		int[] rank = new int[N];
		StringTokenizer st;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			dung[i][0] = Integer.parseInt(st.nextToken()); // 몸무게
			dung[i][1] = Integer.parseInt(st.nextToken()); // 키
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(j == i)
					continue;
				
				if(dung[i][0] < dung[j][0] && dung[i][1] < dung[j][1])
					rank[i]++;
			}
		}
		
		for(int i = 0; i < N; i++) {
			bw.write(++rank[i] + " ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
}