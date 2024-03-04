import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 바구니
		int M = sc.nextInt(); // 공바꾸는 횟수

		int[] ball = new int[N];
		int[] newBall = new int[N];

		for (int i = 0; i < N; i++) {
			ball[i] = i + 1;
			newBall[i] = i + 1;
		}

		for (int a = 0; a < M; a++) {

			int i = sc.nextInt();
			int j = sc.nextInt();

			newBall[j - 1] = ball[i-1];
			newBall[i - 1] = ball[j-1];

			ball[i-1] = newBall[i-1];
			ball[j-1] = newBall[j-1];			

		}

		// 배열출력
		for (int n = 0; n < N; n++) {
			System.out.print(ball[n]+" ");
		}

	}
}
