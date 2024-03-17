import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //정수 갯수
		int[] arr = new int[N]; //그만큼 숫자받기
		
		int min = 1000000;
		int max = -1000000;
		
		for(int n = 0; n < N; n++) {
			arr[n] = sc.nextInt();
			max = Math.max(max, arr[n]);
			min = Math.min(min, arr[n]);
		}
		
		System.out.println(min + " "+ max);
		
	}
}