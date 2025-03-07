import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		long[] guitar = new long[N];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());

			st.nextToken(); // 기타 이름

			String str = st.nextToken();

			for (int s = 0; s < M; s++) {
				if (str.charAt(s) == 'Y') {
					guitar[n] |= 1L << s; // Long 타입을 1씩 다 체킹하는 것임
				}
			}
		}

		int max = 0;
		int minCount = Integer.MAX_VALUE;

		// 기타의 모든 조합을 보기위함.
		for (int bit = 1; bit < (1 << N); bit++) {
			long playableSongs = 0;
			int count = 0;

			for (int i = 0; i < N; i++) {
				if ((bit & (1 << i)) != 0) { // i번째 기타가 선택된 경우
					playableSongs |= guitar[i];
					count++;
				}
			}

			int songCount = Long.bitCount(playableSongs);

			if (max == songCount) {
				//조합을 고려해야하기 때문에 break를 하면 안된다.
				minCount = Math.min(minCount, count);
			} else if (songCount > max) {
				//더 많은 곡을 연주할 수 있는 경우는 갱신
				max = songCount;
				minCount = count;
			}

		}

		if (max == 0) {
			System.out.println(-1);
			return;
		}

		System.out.println(minCount);

	}
}