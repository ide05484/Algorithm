import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 행
		int M = sc.nextInt(); // 열

		int[][] arr = new int[N + 1][M + 1]; // 숫자

		for (int r = 1; r < N + 1; r++) {
			for (int c = 1; c < M + 1; c++) {
				arr[r][c] = sc.nextInt();
			}
		}

		int K = sc.nextInt(); // 구해햐할 좌표 개수

		for (int k = 0; k < K; k++) {

			int i = sc.nextInt();
			int j = sc.nextInt();

			int x = sc.nextInt();
			int y = sc.nextInt();

			int sum = 0;

			for (int r = i; r <= x; r++) {
				for (int c = j; c <= y; c++) {
					sum += arr[r][c];
				}
			}
			
			System.out.println(sum);

		}
	}
}