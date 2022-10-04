import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		HashSet<String> str = new HashSet<>();
		for(int i = 0; i < N; i++) {
			str.add(br.readLine());
		}
		ArrayList<String> temp = new ArrayList(str);
		Collections.sort(temp, new Comparator<String>() {
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) {
					return s1.compareTo(s2);
				}
				else {
					return s1.length() - s2.length();
				}
			}
		});
		
		for(String s : temp) {
			bw.write(s + "\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
}