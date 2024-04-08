import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 주어지는 2xn에서의 n

		long[] arr = new long[1001];// 한칸더 크게, 최대1000

		arr[1] = 1;
		arr[2] = 2;

		for (int i = 3; i <= n; i++) {
			arr[i] = (arr[i - 1] + arr[i - 2]) % 10007;
			//범위를 벗어나기 때문에 나누고 저장해두는 것이 이롭다
		}

		System.out.println(arr[n] % 10007);
	}
}