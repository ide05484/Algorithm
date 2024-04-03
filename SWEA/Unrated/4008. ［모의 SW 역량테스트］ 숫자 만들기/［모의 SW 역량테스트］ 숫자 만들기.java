import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] card;
	static int[] calCount;
	static int N;
	static int[] result;
	static int max;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine()); // 숫자 개수
			calCount = new int[4]; // 사칙연산 수 담을 거
			card = new int[N]; // 카드 수 담을 거

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int c = 0; c < 4; c++) {
				calCount[c] = Integer.parseInt(st.nextToken()); // 연산자 개수 받아줌
			}

			st = new StringTokenizer(br.readLine());

			for (int n = 0; n < N; n++) {
				card[n] = Integer.parseInt(st.nextToken());// 하나씩 숫자 받아줌
			}

//			visit = new boolean[cal.size()]; // 방문체크배열
			result = new int[N - 1]; // 결과저장배열
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;

			perm(0); // 모든 조합을 만들자
			StringBuilder sb = new StringBuilder();
			sb.append(max - min);

			System.out.println("#" + tc + " " + sb);

		} // 테케마감
	}// main마감

	private static void perm(int idx) {
		if (idx == N - 1) {
			// 여기에 오면 모든 사칙연산 조합이 들어옴
			doCalculate();
			return;
		}

		for (int i = 0; i < 4; i++) {
			
			if(calCount[i] == 0) { //없으니까 넘어가잉
				continue;
			}
			
			result[idx] = i;
			calCount[i]--; // 해당 인덱스 개수를 하나씩 빼빼
			perm(idx + 1);

			// 원복해 원복해
			calCount[i]++;
		}
	}

	private static void doCalculate() {
		// 계산해줘잉

		int calResult = card[0]; // 계산결과 시작은 젤 첫 숫자

		for (int n = 0; n < N - 1; n++) {
			if (result[n] == 0) {
				calResult += card[n + 1];
			} else if (result[n] == 1) {
				calResult -= card[n + 1]; // 다음거 빼줘
			} else if (result[n] == 2) {
				calResult *= card[n + 1];
			} else {
				calResult /= card[n + 1];
			}

		}

		max = Math.max(max, calResult); // max값 갱신해
		min = Math.min(min, calResult); // min값 갱신해
	}
}