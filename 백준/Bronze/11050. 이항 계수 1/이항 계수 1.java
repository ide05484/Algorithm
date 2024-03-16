import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//이항 계수란?
		//N개 중에서 K개를 뽑는 순서 상관없은 조합의 경우의 수
		//nCr
		
		int N = sc.nextInt(); 
		int K = sc.nextInt(); 
		
		int upNum = 1; //분자
		int downNum = 1; //분모
		
		for(int i = K+1; i <= N; i++) {
			upNum *= i;
		}
		//조합식에서 K!리얼만큼은 무조건 없어지기 때문
		
		for(int i = 1; i <= N-K; i++) {
			downNum *= i;
		}
		
		System.out.println(upNum/downNum);
		
	}
}