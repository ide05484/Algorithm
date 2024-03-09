import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			String num = sc.next(); // 문자열로 받아야 게씀!
			int len = num.length(); // 문자열 길이

			if (num.equals("0"))
				break; // 0이 들어오면 멈춰!
			
			String answer = "yes"; //기본값은 yes로

			// 반만 돌면 되기 때문에 문자열의 절반까지만 본다!
			// =을 안 붙인 이유는 홀수일때 가운데를 안 봐도 됨 (가운데는 어차피 같음!)
			for (int i = 0; i < len / 2; i++) {
				if (num.charAt(i) != num.charAt((len - 1) - i)) {
					//하나라도 달라지면
					answer = "no"; //바꿔주자
					break;
				}
			}
			//다 돌고 나오면
			System.out.println(answer);
		}
	}
}