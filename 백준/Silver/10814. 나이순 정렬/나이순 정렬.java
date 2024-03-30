import java.util.Arrays;
import java.util.Scanner;

public class Main {

	// 온라인에 가입한 회원들 클래스
	static class Person implements Comparable<Person> {

		int age;
		String name;

		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(Person o) {
			return this.age - o.age; //나이로 오름차순 정렬
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 가입한 회원수
		Person[] arr = new Person[N];
		
		for(int n = 0; n < N; n++) {
			arr[n] = new Person(sc.nextInt(), sc.next()); //사람 넣어줍니다
		}
		
		Arrays.sort(arr);
		
		for(int n = 0; n < N; n++) {
			System.out.println(arr[n].age + " "+ arr[n].name);
		}
	}
}