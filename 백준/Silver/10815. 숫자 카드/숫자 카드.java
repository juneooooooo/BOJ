import java.util.*;
import java.io.*;
public class Main {
	static int N, M;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			bw.write(String.valueOf(binarySearch(tmp)) + ' ');
		}
		bw.flush();
		bw.close();
		br.close();	
	}
	
	static int binarySearch(int num) {
		int start = 0;
		int mid = 0;
		int end = N - 1;
		while(start <= end) {
			mid = (start + end) / 2;
			int val = arr[mid];
			
			if(num == val) 
				return 1;
			
			if(num > val) 
				start = mid + 1;
			else 
				end = mid - 1;
		}	
		return 0;
	}
}