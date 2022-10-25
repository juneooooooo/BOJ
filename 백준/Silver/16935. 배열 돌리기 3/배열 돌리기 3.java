import java.util.*;
import java.io.*;

public class Main {
	static int[][] map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // y
		int M = Integer.parseInt(st.nextToken()); // x
		int R = Integer.parseInt(st.nextToken()); // 연산 개수
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int order = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < R; i++) {
			order = Integer.parseInt(st.nextToken());
			
			switch(order) {
				case 1 : // 상하 반전
					one();
					break;
				case 2 : // 좌우 반전
					two();
					break;
				case 3 : // 오른쪽 90도
					three();
					break;
				case 4 : // 왼쪽 90도
					four();
					break;
				case 5 : // 그룹 오른쪽 90도
					five();
					break;
				case 6 : // 그룹 왼쪽 90도
					six();
					break;
			}
		}
		
		print();
	}
	
	static void one() { // 상하 반전
		int temp;
		
		for(int y = 0; y < map.length/2; y++) {
			for(int x = 0; x < map[0].length; x++) {
				temp = map[map.length - 1 - y][x];
				map[map.length - 1 - y][x] = map[y][x];
				map[y][x] = temp;
			}
		}
	}
	
	static void two() { // 좌우 반전
		int temp;
		
		for(int x = 0; x < map[0].length/2; x++) {
			for(int y = 0; y < map.length; y++) {
				temp = map[y][map[0].length - x - 1];
				map[y][map[0].length - x - 1] = map[y][x];
				map[y][x] = temp;
			}
		}
	}
	
	static void three() { // 오른쪽 90도
		int[][] new_map = new int[map[0].length][map.length];
		int temp;
		
		for(int y = 0; y < map.length; y++) {
			for(int x = 0; x < map[0].length; x++) {
				new_map[x][map.length - 1 - y] = map[y][x];
			}
		}
		
		map = new_map;
	}
	
	static void four() { // 왼쪽 90도
		int[][] new_map = new int[map[0].length][map.length];
		int temp;
		
		for(int y = 0; y < new_map.length; y++) {
			for(int x = 0; x < new_map[0].length; x++) {
				new_map[y][x] = map[x][new_map.length - 1 - y];
			}
		}
		
		map = new_map;
	}
	
	static void five() { // 그룹 오른쪽 90도
		int[][] new_map = new int[map.length][map[0].length];
		int temp;
		
		int row = map.length; // 1->2, 2->3, 3->4, 4->1
		int col = map[0].length;
		
		for(int y = 0; y < row/2; y++) { // 1 -> 2
			for(int x = 0; x < col/2; x++) {
				new_map[y][x + col/2] = map[y][x];
			}
		}
		
		for(int y = 0; y < row/2; y++) { // 2 -> 3
			for(int x = col/2; x < col; x++) {
				new_map[y + row/2][x] = map[y][x];
			}
		}
		
		for(int y = row/2; y < row; y++) { // 3 -> 4
			for(int x = col/2; x < col; x++) {
				new_map[y][x - col/2] = map[y][x];
			}
		}
		
		for(int y = row/2; y < row; y++) { // 4 -> 1
			for(int x = 0; x < col/2; x++) {
				new_map[y - row/2][x] = map[y][x];
			}
		}
		
		map = new_map;
	}
	
	static void six() { // 그룹 왼쪽 90도
		int[][] new_map = new int[map.length][map[0].length];
		int temp;
		
		int row = map.length; // 1->4, 4->3, 3->2, 2->1
		int col = map[0].length;
		
		for(int y = 0; y < row/2; y++) { // 1 -> 4
			for(int x = 0; x < col/2; x++) {
				new_map[y + row/2][x] = map[y][x];
			}
		}
		
		for(int y = row/2; y < row; y++) { // 4 -> 3
			for(int x = 0; x < col/2; x++) {
				new_map[y][x + col/2] = map[y][x];
			}
		}
		
		for(int y = row/2; y < row; y++) { // 3 -> 2
			for(int x = col/2; x < col; x++) {
				new_map[y - row/2][x] = map[y][x];
			}
		}
		
		for(int y = 0; y < row/2; y++) { // 2 -> 1
			for(int x = col/2; x < col; x++) {
				new_map[y][x - col/2] = map[y][x];
			}
		}
		
		map = new_map;
	}
	
	static void print() { // 배열 출력
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}