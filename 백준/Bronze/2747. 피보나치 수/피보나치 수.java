import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //주어지는 피보나치수
		
		int[] fibo = new int[46]; //45보다 작거나 같은 자연수
		
		fibo[1] = 1;
		fibo[2] = 1;
		
		for(int n = 2; n <= N; n++) {
			fibo[n] = fibo[n-1] + fibo[n-2];
		}
		
		System.out.println(fibo[N]);
	}
}