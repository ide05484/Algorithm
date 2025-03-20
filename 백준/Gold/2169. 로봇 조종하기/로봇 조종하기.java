import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] mars = new int[N][M]; //화성
		
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				mars[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dp = new int[N][M];
		
		dp[0][0] = mars[0][0];
		
		for(int c = 1; c < M; c++) {
			dp[0][c] = dp[0][c-1] + mars[0][c];
		}
		
		for(int r = 1; r < N; r++) {
			
			//위에서 오는 값
			for(int c = 0; c < M; c++) {
				dp[r][c] = dp[r - 1][c] + mars[r][c];
			}
			
			//왼쪽에서 오는 값
			int[] left = new int[M];
			
			left[0] = dp[r][0];
			
			for(int c = 1; c < M; c++) {
				left[c] = Math.max(dp[r][c-1], left[c-1]) + mars[r][c];
			}
			
			//오른쪽에서 오는 값
			int[] right = new int[M];
			
			right[M-1] = dp[r][M-1];
			
			for(int c = M-2; c >= 0; c--) {
				right[c] = Math.max(dp[r][c+1], right[c+1]) + mars[r][c];
			}
			
			for(int c = 0; c < M; c++) {
				dp[r][c] = Math.max(dp[r][c], left[c]);
				dp[r][c] = Math.max(dp[r][c], right[c]);
			}
			
		}
		
		System.out.println(dp[N-1][M-1]);
		
	}
}