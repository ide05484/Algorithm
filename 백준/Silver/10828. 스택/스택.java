import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 명령 갯수
		sc.nextLine();// 개행문자제거

		Stack<String> stack = new Stack<>();

		StringBuilder sb = new StringBuilder();
		
		for (int n = 0; n < N; n++) {
			String str = sc.nextLine(); // 명령어를 받은 다음

			if (str.equals("top")) {
				if (stack.isEmpty()) {
					sb.append("-1"+ "\n");
				} else {
					sb.append(stack.peek() + "\n");
				}
			} else if (str.equals("pop")) {
				if (stack.isEmpty()) {
					sb.append("-1" + "\n");
				} else {
					sb.append(stack.pop() + "\n");
				}
			} else if (str.equals("size")) {
				sb.append(String.valueOf(stack.size()) + "\n");
			} else if (str.equals("empty")) {
				if (stack.isEmpty()) {
					sb.append("1" + "\n");
				} else {
					sb.append("0" + "\n");
				}
			} else { // push하는 명령어
				String[] num = str.split(" "); // 공백을 기준으로 분리
				// 인덱스 값은 -1해줘야 마지막 숫자만을 볼 수 있음
				stack.push(num[1]);
				continue;
			}
		}
		String answer = sb.toString();
		System.out.println(answer);

	}// main
}