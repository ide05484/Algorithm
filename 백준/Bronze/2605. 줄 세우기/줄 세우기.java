import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 학생수
		int[] num = new int[N]; // 번호받을 배열
		int[] student = new int[N]; // 학생 번호 배열
		int[] result = new int[N]; // 최종결과

		for (int n = 0; n < N; n++) {
			num[n] = sc.nextInt();// 번호받음
			student[n] = n + 1; // 학생번호받음
		}

		result[0] = student[0];

		for (int n = 1; n < N; n++) { // 학생번째
			// 뒤에서부터 계속 한칸씩 뒤로 밀어줌
			for (int i = n - 1; i >= num[n]; i--) {
				result[i + 1] = result[i];
			}
			result[num[n]] = student[n];
		}

		for (int r = N - 1; r >= 0; r--) {
			System.out.print(result[r] + " ");
		}
	}
}