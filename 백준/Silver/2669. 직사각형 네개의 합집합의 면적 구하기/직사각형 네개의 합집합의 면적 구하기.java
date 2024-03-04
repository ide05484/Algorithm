import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[][] rect = new int[100][100];

		for (int i = 0; i < 4; i++) {

			// 좌표를 넣어준다.
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			int count = 1;
			
			//넓이를 구하려면 좌표를 서로 빼고 -1를 하는것이 맞다.
			for (int r = 100 - x2; r < 100 - x1; r++) {
				for (int c = y1; c < y2; c++) {
					rect[r][c]  = count++; //거기 1개씩 추가
				}
			}

		} // 테케
		
		int sum = 0; //넓이구할 변수
		
		for(int r = 0; r<100; r++) {
			for(int c = 0; c<100; c++) {
				//0이 아닌것은 직사각형이 덮힌거임!
				if(rect[r][c] != 0) {
					sum++;
				}
			}
		}
		
		System.out.println(sum);
	}
}