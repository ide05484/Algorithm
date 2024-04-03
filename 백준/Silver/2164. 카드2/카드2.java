import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //카드 개수

		Queue<Integer> card = new LinkedList<>(); //넣엇다 뻇다할 곳
		
		for(int n = 1; n <= N; n++) {
			card.add(n); //추가추가
		}
		
		while(card.size() > 1) { //1개보다 카드가 많이 있다면?
			card.poll(); //젤 앞에꺼 한장 버리고
			card.add(card.poll()); //그다음 버리는거를 뒤에 넣는다 FIFO
		}
		
		//카드가 1장만 낭을때
		System.out.println(card.peek());
	}
}