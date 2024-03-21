import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // N번째 영화 수

		int n = 666;
		int count = 1;

		while (count != N) {
			n++;
            //666이 들어있는지 검산
			if(String.valueOf(n).contains("666")) {
				count++;
			}
		}
		
		System.out.println(n);
	}
}