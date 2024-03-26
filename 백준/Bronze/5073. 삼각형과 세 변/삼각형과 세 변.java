import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String answer = "";

		while (true) {

			int A = sc.nextInt();
			int B = sc.nextInt();
			int C = sc.nextInt();
			// 세변의 길이를 받습니다.

			if (A == 0 && B == 0 && C == 0)
				break;
			// 셋다 0이라면 종료

			int max = 0;
			int next1 = 0; // 가장긴변제외1
			int next2 = 0; // 가장긴변제외2

			// 가장 긴 변의 길이를 구해준다!!
			max = Math.max(max, A);
			max = Math.max(max, B);
			max = Math.max(max, C);

			if (max == A) {
				next1 = B;
				next2 = C;
			} else if (max == B) {
				next1 = A;
				next2 = C;
			} else {
				next1 = A;
				next2 = B;
			}

			// 삼각형의 조건을 만족하지 못한다면?
			if (max >= next1 + next2) {
				answer = "Invalid";
				System.out.println(answer);
				continue;
			}

			// 정삼각형
			if (A == B && B == C && A == C) { // 세변의 길이가 모두 같다면
				answer = "Equilateral";
				System.out.println(answer);
				continue;
			}
			
			//이등변 삼각형
			if (A == B || B == C || C == A) {
				answer = "Isosceles";
				System.out.println(answer);
				continue;
			}
			
			//삼각형이긴 한데 모든 조건이 아니라면
			answer = "Scalene";
			System.out.println(answer);
		}
	}
}