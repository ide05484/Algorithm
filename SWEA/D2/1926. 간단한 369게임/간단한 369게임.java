import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String N = sc.next(); // 숫자게임끝
		int num = Integer.parseInt(N);
		String[] game = new String[num]; // 게임할 배열

		for (int n = 0; n < num; n++) {
			String gameNum = Integer.toString(n+1);
			game[n] = gameNum;
		}
		
		int[] count = new int[num];
		
		for (int n = 0; n < num; n++) {
			for (int j = 0; j < game[n].length(); j++) {
				if (game[n].charAt(j) == '3' || game[n].charAt(j) == '6' || game[n].charAt(j) == '9') {
					count[n]++;
				}
			}
			
			if(count[n] == 1) { //만약에 1개면
				game[n] = "-";
			} else if (count[n] == 2) {
				game[n] = "--";
			} else if(count[n] == 3) {
				game[n] = "---";
			}
		}
		
		for(int n = 0; n< num; n++) {
			System.out.print(game[n] + " ");
		}
	}
}
