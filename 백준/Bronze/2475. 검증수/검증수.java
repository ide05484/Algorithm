import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int sum = 0; // 합계

		for (int i = 0; i < 5; i++) {
			int num = sc.nextInt(); //숫자 주어짐
			sum += Math.pow(num, 2);
		}
		
		System.out.println(sum%10);
	}
}