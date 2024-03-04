import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		//세로줄
		for(int i = 0; i<N; i++) {
			//빈칸을 넣을 수 있음
			for(int j = 0; j<i; j++) {
				System.out.print(" ");
			}
			//별을 넣을 수 있음
			for(int j = i; j<2*N-i-1; j++) {
				System.out.print("*");
			}
			//줄나눔
			System.out.println();
		}
	}
}
