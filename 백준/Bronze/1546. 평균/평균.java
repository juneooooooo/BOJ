import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		double[] arr = new double[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		double max = arr[N - 1];
		double sum = 0;
		for(int i = 0; i < N; i++) {
			sum += (arr[i] / max) * 100;
		}
		
		System.out.println(sum / N);
		
		//bw.flush();
		//bw.close();
		br.close();
	}
}