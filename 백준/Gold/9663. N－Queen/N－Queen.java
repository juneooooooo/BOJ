import java.util.*;
import java.io.*;

public class Main {
	static int[] queen;
	static int N;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		queen = new int[N];
		
		nQueen(0);
		
		System.out.println(answer);
		
		//bw.flush();
		//bw.close();
		br.close();
	}
	
	static void nQueen(int x) {
		if(x == N) { // 모든 열을 확인해서 퀸을 모두 놓은 경우
			answer++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			queen[x] = i;
			
			if(isQueen(x)) { // 퀸을 놓을 수 있으면 다음 열 확인
				nQueen(x + 1);
			}
		}
	}
	
	static boolean isQueen(int x) { // 같은 열에는 무조건 1개만 두기 때문에 확인 불필요
		for(int i = 0; i < x; i++) { 
			if(queen[x] == queen[i]) // 같은 행에 존재하는 경우
				return false;
			else if(Math.abs(x - i) == Math.abs(queen[x] - queen[i])) 
				return false; // 대각선(y값 차이와 x값 차이가 같음)에 존재하는 경우
		}
		return true;
	}
	
}