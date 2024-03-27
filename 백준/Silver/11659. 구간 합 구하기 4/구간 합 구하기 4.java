import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //수의 개수
		int M = Integer.parseInt(st.nextToken()); //합을 구하는 개수
		
		int[] arr = new int[N+1];
		int[] sum = new int[N+1]; //누적합 배열
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i < N+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); //배열에 숫자를 넣어준다.
			sum[i] = sum[i-1] + arr[i]; //누적해준다
		}
		
		int answer = 0;
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < M; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			answer = sum[end] - sum[start-1]; //누적합을 빼준다
			
			sb.append(answer + "\n");
		}
		
		System.out.println(sb);
	}
}