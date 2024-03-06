import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 수 갯수
		int count = N; // 숫자 갯수만큼 일단 시작

		for (int n = 0; n < N; n++) {

			int num = sc.nextInt(); // 수를 받아

			if (num == 1) { //1은 소수가 아닙니다!
				count--;//그러니까 하나 빼줘
				continue;
			} else if (num == 2) { //2는 1과 자기자신을 뺐을 때 나눌게 없으니까 소수고
				//그러니까 그냥 지속해
				continue;
			}
			
			//나머지는 본인과 1을 뺀 수를 돌면서 나눠주고
			for (int i = 2; i < num; i++) {
				if (num % i == 0) {
					count--; // 하나 빼준다 나머지가 없다면 소수가 아님...
					break;
				}
			}
		}
		System.out.println(count);
	}
}