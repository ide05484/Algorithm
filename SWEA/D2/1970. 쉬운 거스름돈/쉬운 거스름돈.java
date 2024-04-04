import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테케갯수

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt() / 10; // 주어지는 금액 = 무조건 0하나 떼고 시작

			int[] give = { 1, 5, 10, 50, 100, 500, 1000, 5000 }; // 줘야할 종류
			int[] count = new int[8]; // 필요한 개수
			int[] needMoney = new int[8]; // 더줘야하니?

			for (int n = 7; n >= 1; n--) {

				if (n == 7) { // 무조건 젤 큰수로 일단 나눠
					count[n] = N / give[n];
					needMoney[n] = N % give[n];
				}

				if (needMoney[n] != 0) {// 나머지가 남는다면?
					count[n - 1] = needMoney[n] / give[n - 1]; //계속해 계속해
					needMoney[n - 1] = needMoney[n] % give[n - 1];
				}
			}
			
			System.out.println("#" + tc + " ");
			for(int n = 7; n >=0; n--) {
				System.out.print(count[n] + " ");
			}
            System.out.println();
		} // 테케끝
	}// main끝
}