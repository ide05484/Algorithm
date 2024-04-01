import java.util.Scanner;

public class Main {

	static int N;
	static int[][] arr;
	static int max;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 퇴사까지 걸리는 날
		arr = new int[N + 1][2]; // 퇴사까지 벌 수 있는 돈 스케줄

		for (int n = 1; n < N+1; n++) {
			arr[n][0] = sc.nextInt(); // 걸리는 시간
			arr[n][1] = sc.nextInt(); // 여기가 돈
		}

		max = 0;
		findMoney(1, 0); // 1일부터 시작 - 0원으로 시작

		System.out.println(max);
	}

	private static void findMoney(int time, int pay) {
		if (time >= N+1) { // 퇴사날이 될때
			if (time == N+1) {
				// 이때만 버는 돈을 구한다....
				max = Math.max(max, pay);
			}
			return;
		}

		// 선택했을 경우
		findMoney(time + arr[time][0], pay + arr[time][1]);

		// 선택안했을 경우
		findMoney(time + 1, pay);
	}
}