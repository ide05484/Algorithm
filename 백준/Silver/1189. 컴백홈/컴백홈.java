import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static char[][] home;
	static int R, C, K;
	static boolean[][] visit;

	static int cnt;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		home = new char[R][C]; // 집가는 길

		for (int r = 0; r < R; r++) {
			String str = br.readLine();

			for (int c = 0; c < C; c++) {
				home[r][c] = str.charAt(c);
			}
		}

		visit = new boolean[R][C];
		cnt = 0;

		int startR = R - 1;
		int startC = 0;

		dfs(startR, startC, 1);

		System.out.println(cnt);

	}

	private static void dfs(int r, int c, int count) {

		if (r == 0 && c == C - 1) {
			if (count == K)
				cnt++;
			
			return;
		}

		if (r < 0 || r >= R || c < 0 || c >= C || visit[r][c] || home[r][c] == 'T')
			return;

		visit[r][c] = true;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			dfs(nr, nc, count + 1);
		}
		
		visit[r][c] = false;

	}
}
