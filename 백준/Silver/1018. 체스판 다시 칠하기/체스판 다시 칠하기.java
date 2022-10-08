import java.util.*;
import java.io.*;

public class Main {
	
	static char[][] arr;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		
		for(int y = 0; y < N; y++) {
			String str = br.readLine();
			for(int x = 0; x < M; x++) {
				arr[y][x] = str.charAt(x);
			}
		}
		
		for(int y = 0; y <= N - 8; y++) {
			for(int x = 0; x <= M - 8; x++) {
				check(y, x);
			}
		}
		
		System.out.println(min);
		
		//bw.flush();
		//bw.close();
		//br.close();
	}
	
	static void check(int y, int x) {
		int cnt = 0;
		char comp = 'W'; // W로 시작하는 경우
		
		for(int row = y; row < y + 8; row++) {
			comp = (comp == 'B') ? 'W' : 'B';
			
			for(int col = x; col < x + 8; col++) {
				if(comp == arr[row][col]) // 다시 칠해야하는 경우
					cnt++;
				
				comp = (comp == 'B') ? 'W' : 'B';
			}
		}
		min = Math.min(min, cnt);
		
		comp = 'B'; // B로 시작하는 경우
		cnt = 0;
		for(int row = y; row < y + 8; row++) {
			comp = (comp == 'B') ? 'W' : 'B';
			
			for(int col = x; col < x + 8; col++) {
				if(comp == arr[row][col]) // 다시 칠해야하는 경우
					cnt++;
				
				comp = (comp == 'B') ? 'W' : 'B';
			}
		}
		min = Math.min(min, cnt);
		
		return;
	}
}