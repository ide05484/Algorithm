import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static class Tomato { // 토마토 위치를 저장할 토마토객체
		int r;
		int c;
		int day; // 시간까쥐

		public Tomato(int r, int c, int day) {
			this.r = r;
			this.c = c;
			this.day = day;
		}
	}

	static int[][] tomato;
	static int N, M;
	static Queue<Tomato> queue;

	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		M = sc.nextInt(); // 세로
		N = sc.nextInt(); // 가로

		tomato = new int[N][M]; // 상자배열

		queue = new LinkedList<>();

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				tomato[r][c] = sc.nextInt();

				if (tomato[r][c] == 1) {
					queue.add(new Tomato(r, c, 0)); // 시작점들을 다 넣어준다 1일
				}
			}
		}

		int count = 0;// 처음부터 익어있다면 그냥 count는 0

		while (!queue.isEmpty()) {
			Tomato here = queue.poll(); // 꺼낸 토마토
			count = here.day;

			for (int d = 0; d < 4; d++) { // 델타를 돌면서
				int nr = here.r + dr[d];
				int nc = here.c + dc[d];
				int nd = here.day + 1;// 다음 날

				// 범위안에 있고, 0일때만 익게만들어줘!
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && tomato[nr][nc] == 0) {
					tomato[nr][nc] = 1;
					queue.add(new Tomato(nr, nc, nd)); // 그리고 그거 추가해줘
				}
			}
		}

		if (check()) { // 만약에 안익은 토마토가 하나라도 있다면?
			count = -1;
		}

		System.out.println(count); // 얼마나 걸리니

	}

	private static boolean check() {

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (tomato[r][c] == 0) {
					return true; // 안익은 토마토가 있어 ㅠ ㅠ
				}
			}
		}
		return false;
	}
}