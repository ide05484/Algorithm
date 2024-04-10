import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트케이스 개수

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt(); // 행
			int M = sc.nextInt(); // 열

			int[][] arr = new int[N][M];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					arr[r][c] = sc.nextInt();
				}
			}

			int[] dr = { 1, -1, 0, 0 };
			int[] dc = { 0, 0, 1, -1 };

			int max = 2; // 최대길이를 알아야해! (최소길이가 2)

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					// 배열을 돌면서

					if (arr[r][c] != 0) {
						// 거기 1이라면

						for (int d = 0; d < 4; d++) {
							// 델타배열을 돌면서 다음을 찾아
							int nr = r + dr[d];
							int nc = c + dc[d];
							
							int count = 1; // 깊이를 세어줄게
							//r,c는 포함하니까

							if (!(nr >= 0 && nr < N && nc >= 0 && nc < M))
								continue; // 범위벗어나면 하지마

							// 범위안에 있을 때
							while (arr[nr][nc] != 0) {

								// 거기가 유적이고, 방문하지 않았던 곳이라면 세어줘
								count++;
								
								nr = nr + dr[d];
								nc = nc + dc[d];
								// 새 좌표를 줘
								
								if (nr < 0 || nr >= N || nc < 0 || nc >= M)
									break; // 새 좌표가 범위를 넘어서면 하지마
							}
							
							max = Math.max(max, count);
						}
					}
				}
			}

			System.out.println("#" + tc + " " + max);
		} // 테케마감
	}
}