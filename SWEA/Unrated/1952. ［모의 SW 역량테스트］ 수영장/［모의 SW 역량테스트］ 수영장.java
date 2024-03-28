import java.util.Scanner;

public class Solution {

	static int[] plan;
	static int day, month, three, year;
	static int min;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테케수

		for (int tc = 1; tc <= T; tc++) {

			day = sc.nextInt(); // 하루권
			month = sc.nextInt(); // 1달권
			three = sc.nextInt(); // 3달권
			year = sc.nextInt(); // 1년권

			plan = new int[13]; // 1번 인덱스를 1월로 계산해주기 위함

			for (int n = 1; n < 13; n++) {
				plan[n] = sc.nextInt(); // 이용계획을 넣어줍니당
			}

			min = year; // 1년권으로 초기화
			DFS(1, 0); // 1월부터 시작, 우선 드는 돈이 0

			System.out.println("#" + tc + " " + min);

		} // 테케 끝
	}// 메인 끝

	private static void DFS(int count, int money) {

		if (count >= 13) { // 13월부터는 없다 되돌아가
			min = Math.min(min, money);
			return;
		}

		if (plan[count] == 0) { //0일이용하기로 했으면 다음거 봐
			DFS(count + 1, money);
			return;
		}

		// 1일권 시작
		DFS(count + 1, money + plan[count] * day);

		// 1달권 시작
		DFS(count + 1, money + month);

		// 3달권 시작
		DFS(count + 3, money + three);

	}
}