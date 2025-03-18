import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[][] game;
	static boolean[] visit;
	static int[] lineup;
	static int max;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 이닝수

		game = new int[N][10]; // 플레이하는 이닝

		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= 9; c++) {
				game[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		visit = new boolean[10];
		lineup = new int[10];

		// 1번타자는 무조건 4번째
		lineup[4] = 1;
		visit[4] = true;
		max = 0;

		perm(2); // 순열로 순서 정하기
		
		System.out.println(max);

	}

	private static void perm(int number) {
		if (number >= 10) {
			// 9명 다 뽑았으면
			playGame();
			return;
		}
		
		for (int i = 1; i < 10; i++) {
			if (!visit[i]) {
				visit[i] = true;
				lineup[i] = number;
				perm(number + 1);
				visit[i] = false;
			}
		}
	}

	private static void playGame() {
		int score = 0;
		int start = 1;

		for (int n = 0; n < N; n++) {
			int out = 0; // 아웃개수
			boolean[] ground = new boolean[4]; // 홈 1루 2루 3루

			to: while (true) {
				for (int i = start; i <= 9; i++) {
					int hit = game[n][lineup[i]];

					switch (hit) {
					case 0:
						out++;
						break;
					case 1:
						for (int j = 3; j >= 1; j--) {
							if (ground[j]) {
								if (j == 3) {
									// 지금 3루에 사람이 있으면
									score++;
									// 획득
									ground[j] = false;
									continue;
								}

								// 1루, 2루는 한칸씩 이동
								ground[j] = false;
								ground[j + 1] = true;
							}
						}

						ground[1] = true;
						break;
					case 2:
						// 2루타
						for (int j = 3; j >= 1; j--) {
							if (ground[j]) {
								if (j == 3 || j == 2) {
									// 지금 3루에 사람이 있으면
									score++;
									// 획득
									ground[j] = false;
									continue;
								}

								ground[j] = false;
								ground[j + 2] = true;
							}
						}

						ground[2] = true;
						break;
					case 3:
						// 3루타
						for (int j = 3; j >= 1; j--) {
							if (ground[j]) {
								score++;
								ground[j] = false;
							}
						}

						ground[3] = true;
						break;
					case 4:
						// 홈런
						for (int j = 3; j >= 1; j--) {
							if (ground[j]) {
								score++;
								ground[j] = false;
							}
						}

						score++; // 홈런이니까~
						break;
					} //swtich

					if (out == 3) {
						start = i + 1; // 다음 타자부터
						if (start == 10)
							start = 1;
						break to;
					}
				} // 9번 타자
				start = 1;
			} // while 문
		} // for 문 (이닝)
		
		max = Math.max(max, score);
	}
}