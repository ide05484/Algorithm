import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static int count;
	static ArrayList<Integer> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt(); // 첫번째 숫자

		int max = 0; // 제일 많이 나올 숫자 갯수
		int nextNum = 0; // 두번째로 올 숫자를 알아둬야함

		
		for (int i = 1; i <= num; i++) {
			list = new ArrayList<>();
			count = 2;
			findNext(num, i);
			max = Math.max(max, count);
			if (max == count) {
				nextNum = i;
			}
		}
		
		list = new ArrayList<>();
		list.add(num);
		list.add(nextNum);
		findNext(num, nextNum);

		System.out.println(max);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}

	}

	// 다음 숫자 구하는 메서드
	static void findNext(int num, int num2) {

		if (num - num2 < 0) {
			return;
		}

		int num3 = num - num2;
		list.add(num3);
		findNext(num2, num3);
		count++;
	}
}