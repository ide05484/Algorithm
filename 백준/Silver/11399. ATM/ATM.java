import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //사람의 수
		int[] atm = new int[N]; //돈뽑는데 걸리는 시간
		
		for(int n = 0; n < N; n++) {
			atm[n] = sc.nextInt();
		}
		
		Arrays.sort(atm); //시간적은순부터 정렬
		
		int[] time = new int[N];
		int sum = 0; //최종합
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j <= i; j++) {
				//누적합
				time[i] += atm[j];
			}
			sum+= time[i];
		}//누적합
		
		System.out.println(sum);
	}
}