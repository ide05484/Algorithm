import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //동전종류
		int K = Integer.parseInt(st.nextToken()); //만들금액
		
		int[] coin = new int[N];
		
		for(int c = 0; c < N; c++) {
			coin[c] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(coin); //작은거부터 정렬하기 위함
		
		int[] dp = new int[K+1];
		
		for(int i = 1; i <= K; i++) {
			int min = Integer.MAX_VALUE; //i원에 대한 카운트
			for(int j = 0; j < N; j++) {
				if(i > coin[j]) {
					if(dp[i-coin[j]] == 0) continue; //0인 것은 없는 경우의 수이니 빼고 생각한다.
					
					min = Math.min(min, dp[i-coin[j]] + 1);
				} else if (i == coin[j]) {
					min = 1;
				}
			}
			
			if(min == Integer.MAX_VALUE) {
				dp[i] = 0;
				continue;
			}
			
			dp[i] = min;
		}
		
		if(dp[K] == 0) {
			dp[K] = -1;
		}
		
		System.out.println(dp[K]);
	}
}