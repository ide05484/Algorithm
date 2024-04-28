import java.util.Scanner;

public class Main {

	static int N, S, count; // count가 답
	static int[] arr;
	static boolean[] sel; // 선택햇니 안했늬

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 주어지는 정수 개수
		S = sc.nextInt(); // 만들어야 하는 합

		arr = new int[N];

		for (int n = 0; n < N; n++) {
			arr[n] = sc.nextInt();
		}

		sel = new boolean[N];

		count = 0;
		comb(0, 0);

		System.out.println(count);
	}

	private static void comb(int n, int sum) {
		if (n >= N) {
			// 다고려했어!
			if (sum == S) {
				for (int i = 0; i < N; i++) {
					if (sel[i]) {// 하나라도 true라면?
						count++; //그거 가지수 하나 맞으니까 더하고 출력
						return;
					}
				}
			} //합 계산

			return; 
		}

		// 선택해
		sel[n] = true;
		comb(n + 1, sum + arr[n]);

		// 안선택할래
		sel[n] = false;
		comb(n + 1, sum);
	}
}
