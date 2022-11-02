import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int[][] A = new int[H][W];
		int[][] B = new int[H + X][W + Y];
		
		for(int i = 0; i < H + X; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < W + Y; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				if(i - X >= 0 && j - Y >= 0) {
					A[i][j] = B[i][j] - A[i - X][j - Y];
				}
				else {
					A[i][j] = B[i][j];
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				sb.append(A[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
		//bw.write();
		//bw.flush();
		//bw.close();
	}
	
}