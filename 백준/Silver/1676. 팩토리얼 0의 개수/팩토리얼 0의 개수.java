import java.util.Scanner;

public class Main {

	public static int N;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 주는 팩토리얼
		
		//0이 끝에 나오려면 2*5의 쌍이 하나 있어야 1개 추가
		//2보다는 5의 갯수가 더 적게 나오기 때문에 5의 갯수만 구하면 알 수 있음
		
		int count = 0; //5의 갯수 세기
		
		for(int i = 1; i<=N; i++) {
			
			int num = i;
			//계속 5를 나누면서...
			//5가 그 숫자 안에 몇번 들어가있는지 세는 거임
			while(num % 5 == 0) {
				count++;
				num/=5;
			}
		}
		System.out.println(count);
	}
}