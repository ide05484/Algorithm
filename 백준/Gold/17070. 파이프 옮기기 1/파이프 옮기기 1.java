import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dir = { 1, 2, 3 }; // 오른쪽, 아래, 오른쪽 대각선
	static int N;
	static int[][] room;

	static int count;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		room = new int[N + 1][N + 1];

		for (int r = 1; r < N + 1; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 1; c < N + 1; c++) {
				room[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		// 파이프가 우 하향 해야 하니까... 1,2부터 탐색해서 나가면 되고,
		// 3방향만 살피면 된다.

		count = 0;
		dfs(1, 2, 1);

		System.out.println(count);

	}

	private static void dfs(int r, int c, int d) {
		if (r <= 0 || r > N || c <= 0 || c > N || room[r][c] == 1)
			return;

		if (r == N && c == N) {
			count++;
			return;
		}

		// 오른쪽으로 갈 때
		if (d == 1 || d == 3) {
			dfs(r, c + 1, 1);
		}

		// 아래로 갈 때
		if (d == 2 || d == 3) {
			dfs(r + 1, c, 2);
		}

		// 대각선
		if (c + 1 <= N && r + 1 <= N && room[r][c + 1] == 0 && room[r + 1][c] == 0) {
			dfs(r + 1, c + 1, 3);
		}

	}
}
