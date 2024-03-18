import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int R = sc.nextInt(); // 반복하는 횟수
			String str = sc.next(); // 반복할 문자열

			String answer = "";

			for (int i = 0; i < str.length(); i++) {
				for (int j = 0; j < R; j++) {
					answer += str.charAt(i);
				}
			}
			
			System.out.println(answer);

		} // 테케마감
	}
}