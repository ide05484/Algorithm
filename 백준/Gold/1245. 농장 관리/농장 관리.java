import java.io.*;
import java.util.*;

public class Main {

	static int[] dr = { 1, 0, -1, 0, 1, 1, -1, -1 };
	static int[] dc = { 0, 1, 0, -1, 1, -1, 1, -1 }; // 8방향 탐색해야함

	static int N, M;
	static int[][] farm;
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		farm = new int[N][M];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				farm[r][c] = Integer.parseInt(st.nextToken());
			}
		} // 입력 완료

		int count = 0;

		visit = new boolean[N][M];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (!visit[r][c] && dfs(r, c))
					count++;
			}
		}

		System.out.println(count);

	}

	private static boolean dfs(int r, int c) {
		visit[r][c] = true;

		boolean isPeak = true;

		for (int d = 0; d < 8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nr >= N || nc < 0 || nc >= M)
				continue;

			if (farm[r][c] < farm[nr][nc])
				isPeak = false;

			if (!visit[nr][nc] && farm[r][c] == farm[nr][nc])
				isPeak &= dfs(nr, nc); // true일때만 유지되도록함
		}

		return isPeak;
	}
}