import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] paper = new int[100][100]; // 도화기크기
		int papercount = sc.nextInt(); // 색종이 수
		
		int count = 1;
		
		for (int i = 0; i < papercount; i++) {
			int left = sc.nextInt(); // 왼쪽 거리
			int bottom = sc.nextInt(); // 아래거리

			for (int j = left; j < left + 10; j++) {
				for (int k = 100 - bottom; k > 90 - bottom; k--) {
					paper[j][k] = count++; // 그 부분을 1로 바꿔줌
				}
			}
			
		}

		int area = 0; // 덮힌 넓이

		// 돌면서 0이 아닌 곳만 +
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (paper[i][j] != 0) {
					area++;
				}
			}
		}
		System.out.println(area);
	}
}