import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int M = sc.nextInt(); // 시작숫자
		int N = sc.nextInt(); // 끝숫자

		int[] prime = new int[N + 1]; // 거기까지 대항하는 숫자
		
		for (int n = 2; n <= N; n++) {
			prime[n] = n;
		}

		for (int i = 2; i <= N; i++) {
			if (prime[i] == 0)
				continue;

			for (int j = 2 * i; j <= N; j += i) { // 두배부터 끝까지 다 바꿔바꿔
				prime[j] = 0;
			}
		}

		for (int m = M; m <= N; m++) {
			if (prime[m] != 0)
				System.out.println(prime[m]);
		}

	}
}