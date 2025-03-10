import java.io.*;
import java.util.*;

public class Main {

	static int[][] laptop;
	static int N, M;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 노트북 세로
		M = Integer.parseInt(st.nextToken()); // 노트북 가로

		int K = Integer.parseInt(st.nextToken()); // 스티커 개수

		laptop = new int[N][M];

		for (int k = 0; k < K; k++) {

			st = new StringTokenizer(br.readLine());

			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			int[][] sticker = new int[R][C]; // 스티커

			for (int r = 0; r < R; r++) {
				st = new StringTokenizer(br.readLine());

				for (int c = 0; c < C; c++) {
					sticker[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			// 스티커 붙이기
			putSticker(R, C, sticker);

		}

		int count = 0;

		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (laptop[n][m] == 1)
					count++;
			}
		}

		System.out.println(count);

	}

	private static void putSticker(int r, int c, int[][] sticker) {

		for (int d = 0; d < 4; d++) {
			// 4방향을 다 탐색해야 해
			for (int n = 0; n <= N - r; n++) {
				// r
				for (int m = 0; m <= M - c; m++) {
					// c
					if (check(sticker, r, c, n, m)) {
						// 붙일 수 있다면 붙여
						for (int nr = 0; nr < r; nr++) {
							for (int nc = 0; nc < c; nc++) {
								if (sticker[nr][nc] == 1)
									laptop[n + nr][m + nc] = sticker[nr][nc];
							}
						}
						
						return; //붙이자마자 끝내용
					}
				}
			}

			sticker = rotate(sticker, r, c); //못붙였으면 회전

			int tmp = r;
			r = c;
			c = tmp;
		}
	}

	private static int[][] rotate(int[][] sticker, int R, int C) {

		int[][] newSticker = new int[C][R];

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				newSticker[c][R - 1 - r] = sticker[r][c];
			}
		}

		return newSticker;
	}

	private static boolean check(int[][] sticker, int R, int C, int n, int m) {

		if (n + R > N || m + C > M)
			return false;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (sticker[i][j] == 1 && laptop[n + i][m + j] == 1)
					return false;
			}
		}
		return true;
	}
}