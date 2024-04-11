import java.util.Scanner;

public class Solution {

	static int[][] game;
	static int N;
	static int[] dr = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dc = { 0, 0, 1, -1, 1, -1, 1, -1 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테케

		for (int tc = 1; tc <= T; tc++) {

			N = sc.nextInt(); // 크기
			int M = sc.nextInt(); // 횟수

			game = new int[N][N];

			game[N / 2 - 1][N / 2 - 1] = game[N / 2][N / 2] = 2; // 백돌
			game[N / 2 - 1][N / 2] = game[N / 2][N / 2 - 1] = 1; // 흑돌

			for (int m = 0; m < M; m++) {

				int c = sc.nextInt() - 1;
				int r = sc.nextInt() - 1;
				// 좌표 받고

				game[r][c] = sc.nextInt(); // 무슨색 돌

				// 여기서 델타배열돌면서 바둑돌을 다 바꿔줌
				for (int d = 0; d < 8; d++) {

					if (r + dr[d] < 0 || r + dr[d] >= N || c + dc[d] < 0 || c + dc[d] >= N) // 범위벗어나면 하지마
						continue;

					if (game[r + dr[d]][c + dc[d]] != 0 && game[r + dr[d]][c + dc[d]] != game[r][c]) {
						// 범위 안에서 다음칸이 0이 아니고 나와 다른 숫자가 있다면

						if (check(r, c, d)) { // game[r][c] 랑 같은게 있는지 확인하고...

							for (int n = 1; n < N; n++) { // 두칸 이상 너머를 보자
								int nr = r + n * dr[d];
								int nc = c + n * dc[d];

								if (nr < 0 || nr >= N || nc < 0 || nc >= N)
									break; // 범위벗어나면 하지마

								if (game[nr][nc] == game[r][c]) { // 거기서 본인을 만난다면?
									break;
								}

								game[nr][nc] = game[r][c]; // 넣어줘 넣어줘
							} // 끝끝

						} // 해당 델타 끝에 같은게 있다면~~~~
					} // 지금 기준 1칸 델타보기끝
				} // 델타끝

//				System.out.println("-----------------------------");
//
//				for (int a = 0; a < N; a++) {
//					for (int b = 0; b < N; b++) {
//						System.out.print(game[a][b] + " ");
//					}
//					System.out.println();
//				}
			} // 돌다두기

			int black = 0; // 흑돌
			int white = 0; // 백돌

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (game[r][c] == 1)
						black++;
					else if (game[r][c] == 2)
						white++;
				}
			}

			System.out.println("#" + tc + " " + black + " " + white);

		} // 테케
	}

	private static boolean check(int r, int c, int d) {
		// 해당 델타배열진행진행

		for (int n = 1; n < N; n++) {
			int nr = r + n * dr[d];
			int nc = c + n * dc[d];

			if (nr < 0 || nr >= N || nc < 0 || nc >= N || game[nr][nc] == 0)
				return false; // 범위벗어나가면 끝끝

			if (game[nr][nc] == game[r][c])
				return true; // 같은거 있음!
		}

		return false;
	}
}
