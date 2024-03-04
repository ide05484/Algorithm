import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String num1 = sc.next();
		String num2 = sc.next();

		int answer = Math.max(swap(num1), swap(num2));

		System.out.println(answer);
	}

	static int swap(String num) {
		String answer = "";

		char[] newNum = num.toCharArray();

		char tmp = newNum[0];
		newNum[0] = newNum[2];
		newNum[2] = tmp;
		

		for (int n = 0; n < 3; n++) {
			answer += newNum[n];
		}
		
		return Integer.parseInt(answer);

	}
}
