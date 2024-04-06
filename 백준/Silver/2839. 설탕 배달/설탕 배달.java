import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 배달해야하는 설탕킬로수

		int[] sugar = new int[N + 1]; // 해당 무게당 배달할 수 있는 최소 봉지수를 저장할 배열

		sugar[3] = 1; // N은 3부터 주어짐

		if (N >= 5) {
			sugar[5] = 1; // 5가 넘어가면 이렇게
		}

		for (int n = 6; n < N + 1; n++) {

			if (sugar[n - 3] == 0 && sugar[n - 5] != 0) {
				sugar[n] = sugar[n - 5] + 1;
				// -3했을 때 0이라면 5를 뺀거 넣어줘
			} else if (sugar[n - 3] != 0 && sugar[n - 5] == 0) {
				sugar[n] = sugar[n - 3] + 1;
				// -5했을 때 0이라면 3를 뺀거 넣어줘
			} else if (sugar[n - 3] != 0 && sugar[n - 5] != 0) {
				// 둘다 0이 아니라면 비교해서
				sugar[n] = Math.min(sugar[n - 3] + 1, sugar[n - 5] + 1);
			}
		}

		if (sugar[N] == 0) {
			sugar[N] = -1;
		} // 만약 만들수 없다면 0개가나온다

		System.out.println(sugar[N]);
	}
}
