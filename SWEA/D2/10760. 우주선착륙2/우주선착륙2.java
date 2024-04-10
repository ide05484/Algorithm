import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테케갯수

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt(); // 행
			int M = sc.nextInt(); // 열

			int[][] mars = new int[N][M]; // 화성

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					mars[r][c] = sc.nextInt(); // 높이 배열
				}
			}

			// 델타배열 상하좌우 왼위 왼아 오위 오아
			int[] dr = { -1, 1, 0, 0, -1, 1, -1, 1 };
			int[] dc = { 0, 0, -1, 1, 1, 1, -1, -1 };

			int count = 0; // 후보지 수

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					// 델타배열을 돕니다
					int photo = 0; // 찍을 수 있는 방향을 카운트 해줄 변수
					for (int i = 0; i < 8; i++) {
						// 델타배열이 범위 안에 있을 때
						if (r + dr[i] >= 0 && r + dr[i] < N && c + dc[i] >= 0 && c + dc[i] < M) {
							// 현재 위치랑 델타를 비교해서 주변높이가 낮으면
							if (mars[r][c] > mars[r + dr[i]][c + dc[i]]) {
								photo++; // 갯수세줌
							}
						}
					} // 델타마감
					//찍을 수 있는 갯수가 4 이상이면?
					if (photo >= 4) {
						count++; //후보지 개수 추가
					}
				} // 열마감
			} // 행마감
			
			System.out.println("#"+tc+" "+count);

		} // 테케마감
	}// main마감
}