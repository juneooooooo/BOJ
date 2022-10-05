import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		long answer = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		answer = arr[0] * arr[N - 1];
		
		System.out.println(answer);
		br.close();
	}
}