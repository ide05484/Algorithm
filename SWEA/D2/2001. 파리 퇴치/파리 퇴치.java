import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();// 테스트케이스 수

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt(); // 배열크기
			int M = sc.nextInt(); // 파리채크기

			int[][] fly = new int[N][N]; // 파리배열

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					fly[r][c] = sc.nextInt();// 파리받기
				}
			}
			
			int max = 0;

			for (int r = 0; r <= N - M; r++) {
				for (int c = 0; c <= N - M; c++) {
					
					int sum = 0;
					
					for(int nr = r; nr < r+M; nr++) {
						for(int nc = c; nc < c+M; nc++) {
							sum += fly[nr][nc];
						}
					}
					max = Math.max(max, sum);
				}
			}

			System.out.println("#" + tc + " " + max);

		} // 테케
	}
}