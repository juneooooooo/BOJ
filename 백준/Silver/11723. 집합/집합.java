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
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int M = Integer.parseInt(br.readLine());
		int S = 0;
		StringTokenizer st;
		int num = 0;
		StringBuilder sb = new StringBuilder();
		
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			String s = st.nextToken();
			
			switch(s) {
				case "add" :
					num = Integer.parseInt(st.nextToken());
					S = S | (1 << num);
					break;
				case "remove" :
					num = Integer.parseInt(st.nextToken());
					S = S & ~(1 << num);
					break;
				case "check" :
					num = Integer.parseInt(st.nextToken());
					int temp = S & (1 << num);
					sb.append(temp > 0 ? 1 : 0).append("\n");
					break;
				case "toggle" :
					num = Integer.parseInt(st.nextToken());
					S = S ^ (1 << num);
					break;
				case "all" :
					for(int i = 1; i <= 20; i++)
						S = S | (1 << i);
					break;
				case "empty" :
					S = 0;
					break;
			}
		}
		System.out.println(sb);
		br.close();
	}

}