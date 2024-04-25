import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextInt()) { //정수가 들어오는지 판별 후 반복문 종료

			int A = sc.nextInt();
			int B = sc.nextInt(); // 두 수 주어짐

			System.out.println(A + B);
		}
		
		sc.close();
	}// main
}