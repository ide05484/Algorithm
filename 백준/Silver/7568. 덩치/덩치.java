import java.util.Scanner;

public class Main {

	// 사람의 키와 몸무게 클래스
	static class Person {
		int weight;
		int tall;

		public Person(int weight, int tall) {
			this.weight = weight;
			this.tall = tall;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 사람의 수

		Person[] arr = new Person[N];

		for (int n = 0; n < N; n++) {
			arr[n] = new Person(sc.nextInt(), sc.nextInt());
		} // 사람을 받아줍니다

		for (int n = 0; n < N; n++) {
			int prize = 1; //1등부터 시작
			
			for (int m = 0; m < N; m++) {
				if(n == m) continue;
				
				// 덩치가 큰것으로 판단 키, 몸무게 둘다 큼!
				if(arr[n].tall < arr[m].tall && arr[n].weight < arr[m].weight) {
					prize ++;
				}
			}
			System.out.print(prize + " ");
		}
	}
}