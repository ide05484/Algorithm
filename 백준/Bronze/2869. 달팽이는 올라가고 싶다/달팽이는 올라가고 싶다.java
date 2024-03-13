import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt(); // 하루에 올라가는 높이
		int B = sc.nextInt(); // 자면서 내려가는 높이
		int V = sc.nextInt(); // 총 올라가야할 높이

		int day = (V - B) / (A - B); // 몇일

		if ((V - B) % (A - B) != 0) {
			day += 1;
		}

		System.out.println(day);
	}
}