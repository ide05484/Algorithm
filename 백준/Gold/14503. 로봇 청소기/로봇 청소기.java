import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] room;
	static boolean[][] visit;

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static int sum;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		room = new int[N][M];

		st = new StringTokenizer(br.readLine());

		int startR = Integer.parseInt(st.nextToken()); // 시작좌표 R
		int startC = Integer.parseInt(st.nextToken()); // 시작좌표 C
		int dir = Integer.parseInt(st.nextToken()); // 바라보고 있는 방향

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				room[r][c] = Integer.parseInt(st.nextToken());
			}
		} // 입력완료

		sum = 0;
		visit = new boolean[N][M];

		clean(startR, startC, dir);

		System.out.println(sum);
	}

	// 청소하기 시작
	private static void clean(int startR, int startC, int dir) {

		if (!visit[startR][startC]) {
			sum++;
			visit[startR][startC] = true;
		}

		for (int d = 0; d < 4; d++) {

			dir = (dir + 3) % 4; // 새 방향
			int nr = startR + dr[dir];
			int nc = startC + dc[dir];
			
			if (room[nr][nc] == 0 && !visit[nr][nc]) {
				clean(nr, nc, dir);
				return;
			}
		}

		// 다 돌고 없으면 후진
		int backR = startR - dr[dir];
		int backC = startC - dc[dir];

		if (room[backR][backC] == 1) return;
		
		clean(backR, backC, dir);
	}
}
