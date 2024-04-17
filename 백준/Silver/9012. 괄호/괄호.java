import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트케이스

		for (int tc = 1; tc <= T; tc++) {

			String str = sc.next(); // 문자열 받기
			String answer = "YES";// 답출력

			Stack<Character> stack = new Stack<>();

			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(') {
					stack.push('('); // 넣는다
				} else { //닫는 괄호가 들어왔을 때
					if (!stack.isEmpty()) {
						// 스택이 차있다면?
						if (stack.peek() == '(') {
							stack.pop(); // 뺴빼
						} else {
							// 아니라면?
							answer = "NO";
							break;
						}
					} else {
						// 비어있다면?
						answer = "NO";
						break;
					}
				}
			}//글자를 다돌았어용
			
			if(!stack.isEmpty()) answer = "NO";
			
			System.out.println(answer);
		}
	}
}