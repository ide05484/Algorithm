import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[][] arr = new int[10][10];
		//9X9 배열인데 1열부터 시작하므로 0열을 비우고 받기위해 +1해줌
		
		int max = 0; //최대값을 구하기 위함
		
		//정답 좌표를 위함
		int idxR = 0;
		int idxC = 0;
		
		for(int r = 1; r<10; r++) {
			for(int c = 1; c<10; c++) {
				arr[r][c] = sc.nextInt();
				max = Math.max(max, arr[r][c]);
				
				if(max == arr[r][c]) {
					idxR = r;
					idxC = c;
				}
			}
		}
		
		System.out.println(max);
		System.out.println(idxR+" "+idxC);
	}
}