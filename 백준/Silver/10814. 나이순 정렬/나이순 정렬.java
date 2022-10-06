import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String[][] mem = new String[N][2]; // 나이, 이름
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			mem[i][0] = st.nextToken();
			mem[i][1] = st.nextToken();
		}
		
		Arrays.sort(mem, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
			}
		});
		
		for(int i = 0; i < N; i++) {
			bw.write(mem[i][0] + " " + mem[i][1] + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}