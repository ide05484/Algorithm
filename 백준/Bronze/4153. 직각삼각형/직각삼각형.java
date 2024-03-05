import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			// 변을 다 받아줍니도
			int A = sc.nextInt();
			int B = sc.nextInt();
			int C = sc.nextInt();

			if (A == 0 && B == 0 && C == 0) {
				break; // 전부 0이면 브레이크
			}

			// max 변을 구하기 위함
			int max = 0;
			max = Math.max(A, B);
			max = Math.max(max, C);

			// max 값 제외 변
			int num1 = 0;
			int num2 = 0;

			if (max == A) {
				num1 = B;
				num2 = C;
			} else if (max == B) {
				num1 = A;
				num2 = C;
			} else {
				num1 = B;
				num2 = A;
			}

			int heru = (int) Math.pow(max, 2);
			int ansurauset = (int) (Math.pow(num1, 2) + Math.pow(num2, 2));

			if (heru == ansurauset)
				System.out.println("right");
			else
				System.out.println("wrong");
		} // 일단돌아~
	}// main
}