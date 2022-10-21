import java.util.*;
import java.io.*;

/*
Arrays.sort(time, new Comparator<int[]>() {
		
		@Override
		public int compare(int[] a, int[] b) {
			if(a[1] == b[1]) {
				return a[0] - b[0];
			}
			
			return a[1] - b[1];
		}
	}); //  [두 수의 비교 결과에 따른 작동 방식]
		//	음수일 경우 : 두 원소의 위치를 교환 안함
		//	양수일 경우 : 두 원소의 위치를 교환 함
*/

public class Main {
	static int max = Integer.MIN_VALUE;
	static int N;
	static char[][] board;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		board = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			
			for(int j = 0; j < N; j++)
				board[i][j] = s.charAt(j);
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				
				if(isRange(i + 1, j)) {
					if(board[i][j] != board[i + 1][j]) {
						swap(i, j, i + 1, j);
						check();
						swap(i, j, i + 1, j);
					}
				}
				
				if(isRange(i, j + 1)) {
					if(board[i][j] != board[i][j + 1]) {
						swap(i, j, i, j + 1);
						check();
						swap(i, j, i, j + 1);
					}
				}
			}
		}
		
		System.out.println(max);
	}
	
	static boolean isRange(int ny, int nx) {
		if(ny < 0 || ny >= N || nx < 0 || nx >= N)
			return false;
		
		return true;
	}
	
	static void swap(int y, int x, int ny, int nx) {
		char c = board[y][x];
		board[y][x] = board[ny][nx];
		board[ny][nx] = c;
	}
	
	static void check() { // C, P, Z, Y
		int sum = 1;
		
		for(int i = 0; i < N; i++) {
			sum = 1;
			char prev = board[i][0];
			
			for(int j = 1; j < N; j++) {
				if(board[i][j] != prev) {
					sum = 1;
				}
				else
					sum++;
				
				prev = board[i][j];
				max = Math.max(sum,  max);
			}
		}
		
		for(int i = 0; i < N; i++) {
			sum = 1;
			char prev = board[0][i];
			
			for(int j = 1; j < N; j++) {
				if(board[j][i] != prev) {
					sum = 1;
				}
				else
					sum++;
				
				prev = board[j][i];
				max = Math.max(sum,  max);
			}
		}
	}
	
}