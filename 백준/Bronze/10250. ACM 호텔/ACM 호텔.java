import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테케 갯수

		for (int tc = 1; tc <= T; tc++) {

			int H = sc.nextInt(); // 세로
			int W = sc.nextInt(); // 가로
			int N = sc.nextInt(); // 몇번째 손님

			int[][] hotel = new int[W][H];

			int client = 1;
			String floor = "";
			String room = "";
			
			//열 우선순회하면서
			out: for (int c = 0; c < W; c++) {
				for (int r = 0; r < H; r++) {
					
					if(client == N) { //같아지면 해당 룸번호 넣어주기
						floor = String.valueOf(r+1); // 몇층
						room = String.valueOf(c+1); // 몇호
						break out;
					}
					client++; //1명씩 손님더해주고
				}
			}
			
			if(room.length() == 1) {
				room = "0"+room;
			}

			System.out.println(floor + room);

		} // 테케
	} // main
}