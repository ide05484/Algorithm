import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 총 시험장 수
		int[] test = new int[N]; // 시험장

		for (int n = 0; n < N; n++) {
			test[n] = sc.nextInt(); // 응시자 수
		}

		int total = sc.nextInt();// 총감독관이 감시할 인원
		int sub = sc.nextInt(); // 부감독관이 감시할 인원

		long people = 0;

		for (int n = 0; n < N; n++) {
			int num = test[n];// 그 고사장의 응시자수 넣기

			if (num - total <= 0) {
				people += 1;// 1명만 필요한거임!
			} else {
				if ((num - total) % sub == 0) {
					people += (num - total) / sub + 1;
				} else {
					people += (num - total) / sub + 2;
				}
			}
		}

		System.out.println(people);
	}
}