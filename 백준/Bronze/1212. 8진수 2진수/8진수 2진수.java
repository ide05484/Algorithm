import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String str = sc.next(); // 주어지는 8진수 숫자

		String[] eight = { "000", "001", "010", "011", "100", "101", "110", "111" };
		// 8진수배열

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			// 뒤에서부터
			int num = str.charAt(i) - '0';
			sb.append(eight[num]); // 해당 숫자번째 8진수 넣어줘
		}

		if (str.equals("0")) {
			// 0으로 들어온 8진수
			System.out.println(0);
		} else {
			while (sb.charAt(0) == '0') {
				//시작이 0이라면 sb에 1부터 해줘
				sb = new StringBuilder(sb.substring(1));
			}
			System.out.println(sb);
		}
	}
}