import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			double[] num = new double[N];
			double avg = 0;
			double sum = 0;
			double cnt = 0;
			
			for(int i = 0; i < N; i++) {
				num[i] = Double.parseDouble(st.nextToken());
				sum += num[i];
			}
			avg = sum / N;
			for(int i = 0; i < N; i++) {
				if(num[i] > avg)
					cnt += 1;
			}
			sb.append(String.format("%.3f", (cnt / N) * 100)).append("%\n");
		}
		System.out.println(sb);
		//bw.flush();
		//bw.close();
		br.close();
	}
}