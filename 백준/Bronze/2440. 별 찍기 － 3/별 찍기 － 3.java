import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		String[][] star = new String[N][N];

		for (int r = 0; r < N; r++) {
			for (int c = N - 1; c >= 0; c--) {
				if (c <= N-r-1)
					star[r][c] = "*";
				else
					star[r][c] = "";
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				System.out.print(star[r][c]);
			}
			System.out.println(); // 줄바꿈용!
		}
	}
}
