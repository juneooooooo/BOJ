import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		TreeSet<Integer> s = new TreeSet<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			s.add(Integer.parseInt(st.nextToken()));
		}

		Iterator iter = s.iterator();
		while(iter.hasNext()) {
			bw.write(iter.next() + " ");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
}