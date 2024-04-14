import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] area;
	static int N;
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 배열크기
		area = new int[N][N];

		int max = 0; // 최대높이를 구해서 거기까지 도는게 나을수도

		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				area[r][c] = Integer.parseInt(st.nextToken());
				max = Math.max(max, area[r][c]);
			}
		} // 입력 완

		int maxCnt = 0;

		for (int i = 0; i <= max; i++) { // 수위가 1일때부터 max까지
			//아무도 물에 잠기지 않을 수 있기 때문에 0부터도 세어줘야 한다!!!!!!
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (area[r][c] == i)
						area[r][c] = 0; // 없애
				}
			}

			visit = new boolean[N][N];
			int count = 0;

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (!visit[r][c] && area[r][c] != 0) {
						DFS(r, c);
						count++;
					}
				}
			}

			maxCnt = Math.max(maxCnt, count);
		}

		System.out.println(maxCnt);
	}

	private static void DFS(int r, int c) {

		if (r < 0 || r >= N || c < 0 || c >= N || area[r][c] == 0)
			return; // 범위밖을 나가면 하지마

		if (!visit[r][c]) {// 방문하지 않은곳만 세

			visit[r][c] = true;
			
			DFS(r+1, c);
			DFS(r, c+1);
			DFS(r-1, c);
			DFS(r, c-1);
		}
	}
}
