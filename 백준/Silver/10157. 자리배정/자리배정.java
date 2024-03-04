import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int C = sc.nextInt(); // 가로
		int R = sc.nextInt(); // 세로

		int[][] stage = new int[R][C]; // 무대

		// 델타 탐색
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		boolean goRight = false;
		boolean goLeft = false;
		boolean goUp = true; // 시작
		boolean goDown = false;

		// 시작좌표
		int r = R - 1;
		int c = 0;

		int K = sc.nextInt(); // K번째 관객

		// 총 칸수만큼 일단 돌아용 K까지
		for (int i = 1; i <= R * C; i++) {

			if (i == 1) {
				stage[r][c] = 1; // 시작좌표부터 찍고
			}

			// K라면 멈춰
			if (i == K) {
				break;
			}

			// 위로가는 방법
			if (goUp) {
				// 뉴 좌표 찍음
				r = r + dr[0];
				c = c + dc[0];
				// 해당 범위 안에 잇으면 + 0이 아닐때
				if ((r + dr[0] >= 0 && r + dr[0] < R) && stage[r + dr[0]][c] == 0) {
					stage[r][c] = i; // 넣어줌
				} else { // 범위 나가버리면
					stage[r][c] = i; // 일단 넣어주고
					goRight = true;
					goUp = false; // 방향틀기
				}
			}
			// 오른쪽행
			else if (goRight) {
				// 뉴 좌표 찍음
				r = r + dr[1];
				c = c + dc[1];
				// 해당 범위 안에 잇으면
				if ((c + dc[1] >= 0 && c + dc[1] < C) && stage[r][c + dc[1]] == 0) {
					stage[r][c] = i; // 넣어줌
				} else { // 범위 나가버리면
					stage[r][c] = i; // 일단 넣어주고
					goRight = false;
					goDown = true; // 방향틀기
				}
			}

			else if (goDown) {
				// 뉴 좌표 찍음
				r = r + dr[2];
				c = c + dc[2];
				// 해당 범위 안에 잇으면
				if ((r + dr[2] >= 0 && r + dr[2] < R) && stage[r + dr[2]][c] == 0) {
					stage[r][c] = i; // 넣어줌
				} else { // 범위 나가버리면
					stage[r][c] = i; // 일단 넣어주고
					goLeft = true;
					goDown = false; // 방향틀기
				}
			}

			else if (goLeft) {
				// 뉴 좌표 찍음
				r = r + dr[3];
				c = c + dc[3];
				// 해당 범위 안에 잇으면
				if ((c + dc[3] >= 0 && c + dc[3] < C) && stage[r][c + dc[3]] == 0) {
					stage[r][c] = i; // 넣어줌
				} else { // 범위 나가버리면
					stage[r][c] = i; // 일단 넣어주고
					goUp = true;
					goLeft = false; // 방향틀기
				}
			}
		}

		if (K > R * C) { // K가 범위를 넘으면 0 출력
			System.out.println(0);
		} else {
			// 돌고 나오면 r이랑 c가 지금 K번째!
			System.out.println((c + 1) + " " + (R - r));
		}

	} // main
}