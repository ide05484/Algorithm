import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 동전종류
		int K = Integer.parseInt(st.nextToken()); // 만들금액

		int[] coin = new int[N];

		for (int c = 0; c < N; c++) {
			coin[c] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(coin); // 작은거부터 정렬하기 위함

		int[] dp = new int[K + 1];
		
		dp[0] = 1;
		
		for (int j = 0; j < N; j++) {
			for(int i = 1; i <= K; i++) {
				if (i >= coin[j]) {
					dp[i] += dp[i - coin[j]]; //해당 동전을 뺀만큼의 경우의수를 다 더해주믄 된다
				}
			}
		}
		System.out.println(dp[K]);
	}
}