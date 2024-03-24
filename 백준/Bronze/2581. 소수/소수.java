import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int M = sc.nextInt(); // 첫 수
		int N = sc.nextInt(); // 마지막 수

		int sum = 0; // 소수의 합 구하기
		int min = 10000; // 10000이하의 자연수

		for (int i = M; i <= N; i++) {

			if (check(i)) {
				sum += i;
				min = Math.min(min, i);
			}
		}

		// 소수가 하나도 없는 거
		if (sum == 0) {
			System.out.println(-1);
			return;
		}

		System.out.println(sum);
		System.out.println(min);

	}

	private static boolean check(int i) {

		if (i == 1)
			return false;

		// 소수판별
		for (int n = 2; n < i; n++) {
			// 나누어떨어지는게 하나라도 있으면 바로 소수아님
			if (i % n == 0) {
				return false;
			}
		}

		// 하나도 없으면 소수맞음
		return true;
	}

}
