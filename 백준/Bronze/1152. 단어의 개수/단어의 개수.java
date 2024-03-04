import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine(); // 문자열 받음

		int count = 1; // 공백보다 1개 더 많은 것이 단어 갯수

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				if (str.length() == 1) {
					count = 0;
					break;
				}
				else if (i != 0 && i != str.length() - 1) {
					count++;
				}
			} else continue;
		}

		System.out.println(count);
		sc.close();
	}
}
