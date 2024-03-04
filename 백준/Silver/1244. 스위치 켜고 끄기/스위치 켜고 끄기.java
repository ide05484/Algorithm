import java.util.Scanner;

public class Main {

	static int[] onOff;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 스위치 갯수
		onOff = new int[N + 1]; // 스위치 상태

		// 0은 빼고합니다
		for (int n = 1; n <= N; n++) {
			onOff[n] = sc.nextInt();
		} // 스위치 초기상태

		int student = sc.nextInt(); // 학생수

		for (int i = 0; i < student; i++) {

			int gender = sc.nextInt(); // 성별
			int num = sc.nextInt(); // 받은 스위치 번호

			if (gender == 1) { // 남자일때
				// 배수만큼!! (배수의 갯수는 나누었을 때의 몫
				for (int n = 1; n <= N / num; n++) {
					change(num * n);
				} // 배수찾아서 반전

			} else { // 여자일때

				change(num); // 본인 일단 바꿔줘

				// 일단 오른쪽 기준으로 세는데
				for (int n = 1; n <= N - num; n++) {

					if (num + n <= N + 1 && num - n > 0) {
						if (onOff[num + n] == onOff[num - n]) {
							// 같다면
							change(num + n);
							change(num - n);
						} else { // 다르다면
							break; // 멈춰!
						}
					} else
						break; // 범위를 벗어나면 멈춰
				}
			}
		}

		for (int n = 1; n <= N; n++) {

			if (n % 20 == 0) { // 20번재까지 썼다면 한줄 띄우자
				System.out.println(onOff[n]);
				continue;
			}

			System.out.print(onOff[n] + " ");

		} // 스위치 초기상태

	} // main

	static void change(int num) {
		if (onOff[num] == 1) {
			onOff[num] = 0;
		} else {
			onOff[num] = 1;
		}
	}
}