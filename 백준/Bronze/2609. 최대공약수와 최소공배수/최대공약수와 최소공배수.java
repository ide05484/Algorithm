import java.util.Scanner;

public class Main {

	static int divisonMax, multipleMin;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int num1 = sc.nextInt(); // 숫자 하나
		int num2 = sc.nextInt(); // 숫자 둘

		divisonMax = 1;
		multipleMin = 1;

		// 둘 중에 더 작은 수 찾기
		// 더 작은 수보다 작거나 같은 것이 최대공약수
		if (num1 > num2) {
			findDivisionMax(num1, num2);
			findMultiMin(num1, num2);

		} else if (num1 < num2) {

			findDivisionMax(num2, num1);
			findMultiMin(num2, num1);

		} else { // 같을 때는 둘 중 아무거나 출력해도 됨
			divisonMax = num1;
			multipleMin = num1;
		}

		System.out.println(divisonMax);
		System.out.println(multipleMin);

	}

	// 최대공약수 구하는 메서드
	public static void findDivisionMax(int num1, int num2) {
		for (int i = num2; i >= 1; i--) {
			if (num1 % i == 0 && num2 % i == 0) {
				// 둘다 나누었을 때 나머지가 없으면
				divisonMax = i;
				return; // 뒤로부터 검색하니까
			}
		}
	}

	// 최소공배수 구하는 메서드
	public static void findMultiMin(int num1, int num2) {
		int multi = 1;// 곱하기
		while (true) {
			if (num1 * multi % num2 == 0) {
				multipleMin = num1 * multi;
				return;
			}
			multi++;
		}
	}
}