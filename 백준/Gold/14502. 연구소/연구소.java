import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] lab;
	static int N, M;
	static int[][] copy;

	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static int max;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		lab = new int[N][M]; // 연구소

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());

			for (int c = 0; c < M; c++) {
				lab[r][c] = Integer.parseInt(st.nextToken());
			}
		} // 임력

		max = 0;
		dfs(0);

		System.out.println(max);
	}

	private static void dfs(int count) {
		if (count == 3) {
			bfs();
			return;
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (lab[r][c] == 0) {
					lab[r][c] = 1;
					dfs(count + 1);
					lab[r][c] = 0; // 다시 바꾸기
				}
			}
		}
	}

	private static void bfs() {

		Queue<Point> queue = new LinkedList();
		copy = new int[N][M];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				copy[r][c] = lab[r][c];
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (lab[r][c] == 2) {
					queue.add(new Point(r, c));
				}
			}
		}

		while (!queue.isEmpty()) {
			Point now = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nr = now.x + dr[d];
				int nc = now.y + dc[d];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M || copy[nr][nc] != 0)
					continue;

				queue.add(new Point(nr, nc));
				copy[nr][nc] = 2;
			}
		}

		findSafe();
	}

	private static void findSafe() {
		int count = 0;

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (copy[r][c] == 0) {
					count++;
				}
			}
		}
		max = Math.max(max, count);
	}
}