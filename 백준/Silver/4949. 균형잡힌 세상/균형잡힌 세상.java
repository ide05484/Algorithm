import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = ""; // 일단초기화
		String answer = ""; //답입력도 초기화

		while (true) {
			str = br.readLine(); // 입력받아
			answer = "yes"; // 답출력
			
			if(str.equals(".")) break;

			Stack<Character> stack = new Stack<>(); // 괄호맞추기

			for (int i = 0; i < str.length(); i++) {
				// 문자열을 돌면서
				if (str.charAt(i) == '[' || str.charAt(i) == '(') {
					// 여는괄호라면 넣어줘
					stack.add(str.charAt(i));
				} else if (str.charAt(i) == ']') {
					if (!stack.isEmpty()) { // 비어있지 않을때
						if (stack.peek() == '[') {
							// 지금 값이 여는괄호라면 짝이맞다!
							stack.pop(); // 버려버려
						} else {
							answer = "no"; // 짝이 안맞아
							break;
						}
					} else {
						answer = "no";
						break;
					}
				} else if (str.charAt(i) == ')') {
					if (!stack.isEmpty()) { // 비어있지 않을때
						if (stack.peek() == '(') {
							// 지금 값이 여는괄호라면 짝이맞다!
							stack.pop(); // 버려버려
						} else {
							answer = "no"; // 짝이 안맞아
							break;
						}
					} else {
						answer = "no";
						break;
					}
				} else
					continue; // 그 무엇도 아니라면 하쥐뫄
			} // 문자열을 다 돌아돌아

			if (!stack.isEmpty())
				answer = "no"; // 여는괄호가 남아있다면 짝이 안맞아

			System.out.println(answer);
		}//while
	}
}
