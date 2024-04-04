import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 계단 개수
		int[] score = new int[N + 1]; // 한계단당 얻을 수 있는 점수

		for (int n = 1; n <= N; n++) {
			score[n] = sc.nextInt(); // 계단 스코어
		}

		int[][] finalScore = new int[N + 1][2]; // 최종 각 계단 점수

		// 첫행은 1계단 올라갔을 때
		// 두번째 행은 2계단 올라갔을 때

		for (int n = 1; n <= N; n++) {
			if (n == 1) {
				finalScore[1][0] = score[1]; // 1계단만 올라간거리
				continue;
			}

			if (n == 2) {
				finalScore[2][0] = finalScore[1][0] + score[2]; // 1계단씩 두번올라간거리
				finalScore[2][1] = score[2]; // 바로 2계단 올라간거리
				continue;
			}
			
			// 그외는 조합해서!
			finalScore[n][0] = finalScore[n - 1][1] + score[n]; // 2계단올라온거에 1계단 올라오기 (연속3칸 연속 1계단을 밟을 수 업숴)
			finalScore[n][1] = Math.max(finalScore[n-2][0], finalScore[n-2][1]) + score[n]; //2칸 올라갈때는 앞(2칸전에)에 뭐가 나오든 상관없으니 더 큰수랑 더해줘
		}
		
		System.out.println(Math.max(finalScore[N][0], finalScore[N][1]));

	}
}
