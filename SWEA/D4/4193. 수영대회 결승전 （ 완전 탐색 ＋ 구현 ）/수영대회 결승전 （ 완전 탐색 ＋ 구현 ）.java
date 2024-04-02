import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	static int[][] sea;
	static int endR, endC, N;
	static int answer;
	static boolean[][] visit; // 방문배열

	// 탐색하기 위한 델타배열
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, -1, 0, 1 };

	static class Here {
		int r;
		int c;

		public Here(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트케이스 수

		for (int tc = 1; tc <= T; tc++) {

			N = sc.nextInt(); // 배열크기
			sea = new int[N][N];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					sea[r][c] = sc.nextInt(); // 수영장 받아용
				}
			}

			int startR = sc.nextInt();// 시작R
			int startC = sc.nextInt();// 시작C

			endR = sc.nextInt(); // 도착R
			endC = sc.nextInt(); // 도착C

			visit = new boolean[N][N]; // 방문했나요?
			answer = -1;
			BFS(startR, startC);

			System.out.println("#" + tc + " " + answer);

		} // 테케끝
	}// main끝

	private static void BFS(int r, int c) {

		Queue<Here> queue = new LinkedList<>();

		queue.offer(new Here(r, c));
		visit[r][c] = true;
		int time = 0;

		while (true) {
			
			int size = queue.size(); //지금 현재 큐사이즈 받아받아
			
			if (size == 0) { //넣을게 없는데 도착하지않은 거면 못 도달하는거임!!!
				return; // 그러니까 할 필요도 없어
			}

			for (int i = 0; i < size; i++) {

				Here here = queue.poll(); // 하나 꺼내주고
				int nr = here.r;
				int nc = here.c; // 새 좌표받기

				if (nr == endR && nc == endC) {
					answer = time;
					return; // 도착지점에 다다르면 나가
				}

				for (int d = 0; d < 4; d++) {
					int hereR = nr + dr[d];
					int hereC = nc + dc[d]; // 델타탐색할 배열

					// 범위안에 있을 때
					if (hereR >= 0 && hereR < N && hereC >= 0 && hereC < N) {
						if (sea[hereR][hereC] == 1 || visit[hereR][hereC]) {
							continue; // 섬이거나 방문했던 곳이면 지나가
						}

						if (sea[hereR][hereC] == 2) { // 회오리를 만났을 때
							if (time % 3 == 2) { // 없어지는 시간
								queue.offer(new Here(hereR, hereC)); // 없어지니까 지나갈 수 있으니까 체크체크
								visit[hereR][hereC] = true; // 방문했으니까 멈춰
							} else {
								// 못지나간다면?
								// 원래 위치에 있어야해
								queue.offer(new Here(nr, nc)); // 원래위치 다시 넣어줌 다음 시간으로 가
								visit[nr][nc] = true;
							}
						} // 회오리라면?

						else if (sea[hereR][hereC] == 0) { // 지나갈 수 있는 곳
							queue.offer(new Here(hereR, hereC)); // 넣고
							visit[hereR][hereC] = true; // 방문처리
						}
					}//범위안에서~~
				}
			} // 큐안의 for
			time++;
		} // 큐
	}
}