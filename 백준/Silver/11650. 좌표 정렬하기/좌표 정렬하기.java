import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static class Dot implements Comparable<Dot> {
		int x;
		int y;

		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Dot o) {
			if (this.x == o.x) { // 같다면 y 좌표로 해줘
				return this.y - o.y;
			}
			return this.x - o.x;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 좌표받을 갯수
		Dot[] dot = new Dot[N]; // 좌표가 들어갈 배열

		for (int n = 0; n < N; n++) {
			dot[n] = new Dot(sc.nextInt(), sc.nextInt()); // 좌표받아줌
		}

		Arrays.sort(dot);

		for (int n = 0; n < N; n++) {
			System.out.println(dot[n].x + " "+ dot[n].y);
		}
	}
}