import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C;
	static int max;
	static char[][] map;
	static boolean[][] visit; // 방문했늬

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken()); // 행
		C = Integer.parseInt(st.nextToken()); // 열

		map = new char[R][C]; // 보물섬

		for (int r = 0; r < R; r++) {
			String str = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = str.charAt(c);
			}
		} // 입력 완

		max = 0; // 최대값

		// 여기서부터 갈 수 있는 육지에서 제일 먼 곳을 출력
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 'L') {
					// 육지인 곳만 돌 수 있숴
					visit = new boolean[R][C];
					BFS(new Point(r, c));
				}
			}
		} // 다 끝냈니 ?

		System.out.println(max - 1);

	}

	private static void BFS(Point p) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(p); // 지금 포인트 넣어
		visit[p.x][p.y] = true; // 방문처리

		int count = 0; // 경로 크기

		while (true) {

			int size = queue.size();

			for (int i = 0; i < size; i++) { // 들어온 큐만큼만 돌면서
				Point here = queue.poll();

				for (int d = 0; d < 4; d++) {
					int nr = here.x + dr[d];
					int nc = here.y + dc[d];

					if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
						if (!visit[nr][nc] && map[nr][nc] == 'L') {
							// 범위안이고 방문하지 않았고, 육지라면 이동
							queue.add(new Point(nr, nc));
							visit[nr][nc] = true;
						}
					}
				}
			}

			if (size == 0) {
				max = Math.max(max, count); // 갱신해주고 나가
				break; // 더 넣은게 없으니까 멈춰줘
			}

			count++; // 다 넣었으면 ++
		}
	}// BFS 끝
}
