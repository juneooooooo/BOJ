import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] num = new int[N];
		int[] sorted = new int[N];
		
		for(int i = 0; i < N; i++) {
			num[i] = sorted[i] = Integer.parseInt(st.nextToken());

		}
		Arrays.sort(sorted);
			
		int rank = 0;
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(int i = 0; i < N; i++) {
			if(!hm.containsKey(sorted[i])) { // (값, 순위) 기존에 있던 값이면 넣지 않음
				hm.put(sorted[i], rank);
				rank++;
			}
		}
		
		for(int i = 0; i < N; i++) {
			bw.write(hm.get(num[i]) + " ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}