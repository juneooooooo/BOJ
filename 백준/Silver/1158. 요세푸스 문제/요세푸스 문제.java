import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 숫자 개수
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) // 1 ~ N 큐에 넣기
			q.add(i);
		
		sb.append("<");
		while(q.size() != 1) {
			for(int i = 0; i < K - 1; i++) // K - 1번째까지 빼고 넣기
				q.add(q.poll());
			
			sb.append(q.poll() + ", "); // K번째
		}
		sb.append(q.poll() + ">");
		
		br.close();
		System.out.println(sb);
	}
}