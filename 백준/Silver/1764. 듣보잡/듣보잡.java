import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashSet<String> hs = new HashSet<>();
		TreeSet<String> answer = new TreeSet<>();
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			hs.add(s);	
		}
		
		for(int i = 0; i < M; i++) {
			String s = br.readLine();
			if(hs.contains(s)) { // 듣보잡
				answer.add(s);
			}
		}
		StringBuilder sb = new StringBuilder();
		
		sb.append(answer.size()).append("\n");
		
		Iterator iter = answer.iterator();
		
		while(iter.hasNext()) {
			sb.append(iter.next()).append("\n");
		}
		
		System.out.println(sb);
		
		//bw.flush();
		//bw.close();
		br.close();
	}
	
}