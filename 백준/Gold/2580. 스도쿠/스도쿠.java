import java.util.*;
import java.io.*;

public class Main {
	
	static int[][] sudoku = new int[9][9];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		for(int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				sudoku[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		fillSudoku(0, 0);
			
		//bw.flush();
		//bw.close();
		//br.close();
	}
	
	static void fillSudoku(int y, int x) {
		if(x == 9) { // 행이 다 채워지면 다음 행으로
			fillSudoku(y + 1, 0);
			return;
		}
		
		if(y == 9) {
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					System.out.print(sudoku[i][j] + " ");
				}
				System.out.println();
			}
			
			System.exit(0);
		}
			
		if(sudoku[y][x] == 0) {
			for(int i = 1; i <= 9; i++) {
				if(isSudoku(y, x, i)) {
					sudoku[y][x] = i;
					fillSudoku(y, x + 1);
				}
			}
			sudoku[y][x] = 0;
			return;
		}
		
		fillSudoku(y, x + 1);
	}
	
	static boolean isSudoku(int y, int x, int val) {
		for(int i = 0; i < 9; i++) { // 가로 확인
			if(val == sudoku[y][i])
				return false;
		}
		
		for(int i = 0; i < 9; i++) { // 세로 확인
			if(val == sudoku[i][x])
				return false;
		}
		
		
		int row = (y / 3) * 3; // 3x3 첫 위치 구하기
		int col = (x / 3) * 3;
		
		for(int i = row; i < row + 3; i++) {
			for(int j = col; j < col + 3; j++) {
				if(val == sudoku[i][j])
					return false;
			}
		}
		
		return true;
	}	
}