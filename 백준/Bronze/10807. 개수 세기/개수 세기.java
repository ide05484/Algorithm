import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //정수 개수
		int[] arr = new int[N];

		for(int n = 0; n < N; n++) {
			arr[n] = sc.nextInt(); //수
		}
		
		int V = sc.nextInt(); //찾으려는 정수
		
		int count = 0;
		
		for(int n = 0; n < N; n++) {
			if(arr[n] == V) count++; //같은거면 세주셈
		}
		
		System.out.println(count);
	}
}
