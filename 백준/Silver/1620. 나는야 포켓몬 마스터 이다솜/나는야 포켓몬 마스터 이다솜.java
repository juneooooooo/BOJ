import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> hm1 = new HashMap<>();
		HashMap<Integer, String> hm2 = new HashMap<>();
		
		for(int i = 1; i <= N; i++) {
			String s = br.readLine();
			hm1.put(s, i);
			hm2.put(i, s);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			String k = br.readLine();
			
			if(hm1.containsKey(k)) {
				sb.append(hm1.get(k)).append("\n");
			}
			else if(hm2.containsKey(Integer.parseInt(k))) {
				sb.append(hm2.get(Integer.parseInt(k))).append("\n");
			}
		}
		System.out.println(sb);
		//bw.flush();
		//bw.close();
		br.close();
	}
	
}