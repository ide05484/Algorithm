import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Point {
		int R, C, time;

		public Point(int r, int c) {
			super();
			R = r;
			C = c;
		}

		public Point(int r, int c, int time) {
			R = r;// 현재좌표
			C = c;
			this.time = time; // 현재 걸릴 시간
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine()); // 테케개수

		StringBuilder sb = new StringBuilder(); // 출력위함

		for (int tc = 1; tc <= TC; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			int W = Integer.parseInt(st.nextToken()); // 빌딩의 열
			int H = Integer.parseInt(st.nextToken()); // 빌딩의 행

			char[][] building = new char[H][W]; // 빌딩지도

			int startR = 0;
			int startC = 0; // 시작위치

			Queue<Point> fire = new LinkedList<>(); // 파이어
			// 불이 먼저 번지고

			for (int r = 0; r < H; r++) {
				String str = br.readLine();
				for (int c = 0; c < W; c++) {
					building[r][c] = str.charAt(c);

					if (building[r][c] == '@') {
						// 상근이의 시작위치
						startR = r;
						startC = c;
					} else if (building[r][c] == '*') {
						fire.add(new Point(r, c));
					}
				}
			}

			int[] dr = { 1, -1, 0, 0, };
			int[] dc = { 0, 0, 1, -1 };

			int time = Integer.MAX_VALUE; // 답

			//////// BFS 시작 //////////
			Queue<Point> queue = new LinkedList<>(); // BFS를 위함
			queue.add(new Point(startR, startC, 0)); // 시작점 넣어

			out: while (true) { // 일단 돌아 빌때까지

				// 불먼저 지르자
				int fireSize = fire.size(); //들어가있는 것만큼만 우선 해줄래?

				for (int i = 0; i < fireSize; i++) {
					Point f = fire.poll();
					int fR = f.R;
					int fC = f.C;

					for (int d = 0; d < 4; d++) {
						int nr = fR + dr[d];
						int nc = fC + dc[d];

						if ((nr >= 0 && nr < H && nc >= 0 && nc < W)
								&& (building[nr][nc] == '.' || building[nr][nc] == '@')) {
							// 범위 안이고, 내가 있는 곳이거나 . 인곳에
							building[nr][nc] = '*'; // 불 붙여
							fire.add(new Point(nr, nc));
						}
					}
				}
				
				int size = queue.size(); //들어가있는 거 만큼만 해볼래
				
				for (int i = 0; i < size; i++) {
					Point here = queue.poll(); // 하나를 끄집어 내
					int R = here.R;
					int C = here.C;

					// 상근이가 이동하자
					for (int d = 0; d < 4; d++) {
						///////////// 상근이 이동/////////////////
						int nr = R + dr[d];
						int nc = C + dc[d]; // 다음으로 상근이가 갈 곳

						if (nr < 0 || nr >= H || nc < 0 || nc >= W) { // 탈출 성공!
							time = Math.min(time, here.time + 1); // 지금시간
							break out;
						}

						if (building[nr][nc] == '.') {
							// 불이난 곳도 아니고 벽도 아닌 곳으로 가자
							building[nr][nc] = '@';
							queue.add(new Point(nr, nc, here.time + 1)); // 갈수있는 곳들을 다 추가해줘
						} // 상근이 이동
					}
				}
				
				if (queue.isEmpty())
					break; // queue가 비면 나가
			} // 큐 다돌았음

			if (time == Integer.MAX_VALUE) {
				sb.append("IMPOSSIBLE" + "\n");
			} else {
				sb.append(time + "\n");
			}
		} // 테케 끝

		System.out.println(sb);
	}
}