import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String[] str = new String[5]; // 5개 문자열을 받을 수 있음
		char[][] charArr = new char[5][15]; // 2차원 배열에 하나씩 넣어줌
		
		int max = 0; // 가장 긴 문자열 길이

		for (int i = 0; i < 5; i++) {
			str[i] = sc.nextLine(); // 문자를 받음
			if (max < str[i].length()) {
				max = str[i].length(); // 문자열 길이max값 받기
			}
			for (int j = 0; j < str[i].length(); j++) {
				charArr[i][j] = str[i].charAt(j);
			}
		}
		
		
		// 열 우선 순회
		for (int j = 0; j < max; j++) {
			for (int i = 0; i < 5; i++) {
				if (charArr[i][j] == '\0') {
					continue;
				}
				System.out.print(charArr[i][j]);
			}
		}
		sc.close();
	}
}
