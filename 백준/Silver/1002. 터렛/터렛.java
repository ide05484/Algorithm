import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트케이스개수

		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {

			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int r1 = sc.nextInt();

			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int r2 = sc.nextInt();

			// 입력완료

			int longR = Math.max(r1, r2); // 긴거리
			int shortR = Math.min(r1, r2);// 짧은거리
			

			double dist = Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));// 두점간의 거리
			
			if (x1 == x2 && y1 == y2) {
				// 중심이 같을 때
				if (r1 != r2) {
					// 반지름이 다르면
					sb.append(0).append("\n");
				} else {
					// 같으면 -1
					sb.append(-1).append("\n");
				}
			} else {
				// 원 두개가 떨어져 있거나 안에서도 붙어있지 않으면
				if (r1 + r2 < dist || dist + shortR < longR) {
					sb.append(0).append("\n");
				} else if (r1 + r2 == dist || longR - shortR == dist) {
					// 내접 또는 외접
					sb.append(1).append("\n");
				} else {
					// 전부 겹치는 원
					sb.append(2).append("\n");
				}
			}
		} // 테케

		System.out.println(sb);
	}// main
}
