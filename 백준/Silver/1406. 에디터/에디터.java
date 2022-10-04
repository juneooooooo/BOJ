import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		LinkedList<Character> ll = new LinkedList<>();
		String s = br.readLine(); // 초기 문자열
		for(int i = 0; i < s.length(); i++) {
			ll.add(s.charAt(i));
		}
		int cursor = s.length(); // 초기 커서는 문장 맨 뒤
		
		int N = Integer.parseInt(br.readLine()); // 명령의 수
		
		ListIterator<Character> iter = ll.listIterator();
		while(iter.hasNext()) {
			iter.next();
		}
		
		for(int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" "); // [0] : 명령, [1] : 문자
			
			switch(line[0]) {
				case "L" :
					if(iter.hasPrevious())
						iter.previous();
					break;
				
				case "D" :
					if(iter.hasNext())
						iter.next();
					break;
					
				case "B" :
					if(iter.hasPrevious()) {
						iter.previous();
						iter.remove();
					}
					break;
					
				case "P" :
					iter.add(line[1].charAt(0));
					break;
			}
		}
		
		for(Character c : ll) {
			bw.write(c);
		}
		
		bw.flush();
		bw.close();
	}
}