import java.util.*;
import java.io.*;

public class Main {
	static int N, K, zero, answer;
	static int[] belt;
	static boolean[] robot;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		belt = new int[2*N + 1];
		robot = new boolean[2*N + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= 2*N; i++)
			belt[i] = Integer.parseInt(st.nextToken());
		
		answer = 0;
		zero = 0;
		while(true) {
			answer++;
			
			rotate();
			
			moveRobot();
			
			if(zero >= K)
				break;
		}
		
		System.out.println(answer);
	}
	
	private static void rotate() { // 1칸씩 회전
		int t1 = belt[2*N];
		for(int i = 2*N; i > 1; i--) { // 벨트 1칸 회전
			belt[i] = belt[i - 1];
		}
		belt[1] = t1;
		
		boolean t2 = robot[2*N];
		for(int i = 2*N; i > 1; i--) { // 로봇 1칸 회전(로봇은 N-1에서 내려감)
			robot[i] = robot[i - 1];
		}
		robot[1] = t2;
	}
	
	private static void moveRobot() { // 가장 먼저 올라온 로봇부터 한칸씩 이동
		if(robot[N]) // 로봇은 내리는 자리에서 즉시 내려감
			robot[N] = false;
		
		for(int i = N - 1; i > 0; i--) { // 로봇은 0 ~ N-1 에 존재함
			if(robot[i] && !robot[i + 1] && belt[i + 1] > 0) {
				robot[i] = false;
				robot[i + 1] = true;
				belt[i + 1]--; // 내구도 1 감소
				
				if(belt[i + 1] == 0)
					zero++;
			} // 이동하려는 칸에 로봇이 없고, 내구도가 1이상이면 이동
		}
		
		if(!robot[1] && belt[1] > 0) { // 올리는 위치에 내구도가 0이 아니면 로봇 올리기
			robot[1] = true;
			belt[1]--;
			if(belt[1] == 0)
				zero++;
		}
		
		if(robot[N]) // 로봇은 내리는 자리에서 즉시 내려감
			robot[N] = false;
	}

}