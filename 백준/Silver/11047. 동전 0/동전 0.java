import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //동전의 개수
		int K = Integer.parseInt(st.nextToken()); //만들 금액
		
		int[] coins = new int[N];
		
		for(int n = 0; n < N; n++) {
			coins[n] = Integer.parseInt(br.readLine());
		}
		
		int count = 0;
		int start = N-1;
		
		while(K > 0) {
			if(coins[start] > K) {
				start--;
				continue;
			}
			
			int tmp = coins[start];
			int used = K / tmp;
			
			count += used;
			K -= tmp * used;
		}
		
		System.out.println(count);
	}
}