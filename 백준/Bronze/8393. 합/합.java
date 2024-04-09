import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //주어지는 n까지의 합
		
		int sum = 0;
		
		for(int n = 1; n <= N; n++) {
			sum += n;
		}
		
		System.out.println(sum);
		
	}
}
