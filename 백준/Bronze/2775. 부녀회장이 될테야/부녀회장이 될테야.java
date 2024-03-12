import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테케

		for (int tc = 1; tc <= T; tc++) {

			int k = sc.nextInt(); // 몇층에 가나요
			int n = sc.nextInt(); // 몇호에 가나요

			int[][] people = new int[k+1][n]; // n호까지 사람이 얼마나 사나요

			for (int c = 0; c < n; c++) {
				people[0][c] = c+1; // 0층
			}

			// 1층부터
			for (int r = 1; r <= k; r++) {
				for (int c = 0; c < n; c++) { // 1행부터
					for (int i = 0; i <= c; i++) { // 전행의 c까지!
						people[r][c] += people[r - 1][i];
					}
				}
			} // 2차원 배열에 값을 넣어줍니다

//			for (int r = 0; r <= k; r++) {
//				for (int c = 0; c < n; c++) {
//					System.out.print(people[r][c] + " ");
//				}
//				System.out.println();
//			}

			System.out.println(people[k][n-1]);

		} // 테케 끝
	}
}