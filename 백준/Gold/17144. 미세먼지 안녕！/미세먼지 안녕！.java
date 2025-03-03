import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static int[][] room;
	static int R, C;
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken()); // 초

		room = new int[R + 1][C + 1]; // 방

		for (int r = 1; r <= R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= C; c++) {
				room[r][c] = Integer.parseInt(st.nextToken());
			}
		} // 입력 완

		while (T != 0) {
			// 지금 있는 미세먼지 기준 확
			diffusion();

			// 그 후 클린
			cleaner();

			T--;
		}

		int sum = 0;

		for (int r = 1; r <= R; r++) {
			for (int c = 1; c <= C; c++) {
				if (room[r][c] != 0 && room[r][c] != -1) {
					sum += room[r][c];
				}
			}
		}

		System.out.println(sum);
	}

	private static void cleaner() {

		// 올라가게 돌기
		int up = -1;
		int down = -1;

		for (int r = 1; r <= R; r++) {
			if (room[r][1] == -1) {
				up = r;
				down = r+1;
				break;
			}
		}

		rotateUp(up);
		rotateDown(down);
	}

	private static void rotateDown(int r) {
		// 아래로 도는 방향
		for (int nr = r + 1; nr < R; nr++) {
			room[nr][1] = room[nr + 1][1];
		}

		for (int c = 1; c < C; c++) {
			room[R][c] = room[R][c + 1];
		}

		for (int nr = R; nr > r; nr--) {
			room[nr][C] = room[nr - 1][C];
		}

		for (int c = C; c > 1; c--) {
			room[r][c] = room[r][c - 1];
		}
		
		room[r][1] = -1;
		room[r][2] = 0;
	}

	private static void rotateUp(int r) {
		// 위로 도는 방향
		for (int nr = r - 1; nr > 1; nr--) {
			room[nr][1] = room[nr - 1][1];
		}

		for (int c = 1; c < C; c++) {
			room[1][c] = room[1][c + 1];
		}

		for (int nr = 1; nr < r; nr++) {
			room[nr][C] = room[nr + 1][C];
		}

		for (int c = C; c > 1; c--) {
			room[r][c] = room[r][c - 1];
		}
		
		room[r][1] = -1;
		room[r][2] = 0;
	}

	private static void diffusion() {

		int[][] tmp = new int[R + 1][C + 1];

		for (int r = 1; r <= R; r++) {
			for (int c = 1; c <= C; c++) {
				if (room[r][c] > 0) {

					int L = room[r][c] / 5; // 확산의 양
					int count = 0;

					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];

						// 공기청정기이거나 칸을 벗어나면
						if (nr <= 0 || nr > R || nc <= 0 || nc > C || room[nr][nc] == -1)
							continue;

						tmp[nr][nc] += L; // 확산
						count++;
					}
					
					tmp[r][c] += room[r][c]; // 기존 먼지 유지
					tmp[r][c] -= L * count;  // 확산된 양 빼기

				}
			}
		}

		for (int r = 1; r <= R; r++) {
			for (int c = 1; c <= C; c++) {
				if (room[r][c] == -1)
					continue; // 공청기 빼고

				room[r][c] = tmp[r][c];
			}
		}
	}
}
