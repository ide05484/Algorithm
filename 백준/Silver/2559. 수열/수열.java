import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 날짜
		int K = sc.nextInt(); // 연속적인 날짜수

		int[] temp = new int[N]; // 온도

		for (int n = 0; n < N; n++) {
			temp[n] = sc.nextInt(); // 온도를 받아줍니도
		}

		int max = Integer.MIN_VALUE; // 최대값 구하기 위함

		// K만큼 구하는거니까
		for (int i = 0; i <= N - K; i++) {
			int sum = 0;
			for (int j = i; j < i + K; j++) {
				sum += temp[j];
			}
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
	}
}