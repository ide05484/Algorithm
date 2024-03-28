import java.util.Scanner;

public class Main {

	static int[][] board;
	static boolean eat; //2개 이상 먹었나요 ?

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		board = new int[5][5]; // 사과먹는 보드

		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				board[r][c] = sc.nextInt(); // 받아받아
			}
		}

		int hereR = sc.nextInt(); // 내가 있는 r
		int hereC = sc.nextInt(); // 내가 있는 c
		
		eat = false;
		DFS(hereR, hereC, 3, 0);
		
		if(eat) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	private static void DFS(int hereR, int hereC, int count, int apple) {

		if(apple >= 2 ) {
			eat = true;
			return;
		}
		
		if (hereR >= 5 || hereC >= 5 || hereR < 0 || hereC < 0 || count < 0) {
			// 3회까지 해
			return;
		}

		if (board[hereR][hereC] == -1)
			return;
		
		int tmp = board[hereR][hereC];
		board[hereR][hereC] = -1;
		
		DFS(hereR + 1, hereC, count - 1, apple + tmp); // 아래
		DFS(hereR - 1, hereC, count - 1, apple + tmp); // 위
		DFS(hereR, hereC + 1, count - 1, apple + tmp); // 오른쪽
		DFS(hereR, hereC - 1, count - 1, apple + tmp); // 왼쪽
		
		board[hereR][hereC] = tmp; //원복
	}
}
