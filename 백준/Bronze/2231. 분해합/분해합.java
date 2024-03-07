import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 받는 숫자

		int result = 0;

		for (int i = 1; i < N; i++) {

			String str = String.valueOf(i); // String으로 바꿈

			int tmpSum = 0; // 일단 각자리수의 합

			for (int j = 0; j < str.length(); j++) {
				tmpSum += str.charAt(j) - '0';
			}

			result = i + tmpSum;

			if (result == N) {
				System.out.println(str);
				break;
			} else {
				result = 0; //다시 바꿔줘
			}
		}
        
        //그것이 전부 다 돌았는데 0 이라면 . . . .
		if (result == 0) {
			System.out.println(result);
		}
	}
}