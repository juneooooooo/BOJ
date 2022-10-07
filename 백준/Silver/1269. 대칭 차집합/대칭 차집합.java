import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		HashSet<Integer> A = new HashSet<>();
		HashSet<Integer> B = new HashSet<>();
		HashSet<Integer> answer = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < a; i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < b; i++) {
			B.add(Integer.parseInt(st.nextToken()));
		}
		
		Iterator iter = A.iterator();
		while(iter.hasNext()) { // A-B 집합 구하기
			int cur = (int) iter.next();
			if(!B.contains(cur))
				answer.add(cur);
		}
		
		iter = B.iterator();
		while(iter.hasNext()) { // B-A 집합 구하기
			int cur = (int) iter.next();
			if(!A.contains(cur))
				answer.add(cur);
		}
		
		System.out.println(answer.size());
		
		//bw.flush();
		//bw.close();
		br.close();
	}
	
}