import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long sum = 0;
		
		Stack<Integer> stack = new Stack<>();
		
		for(int n = 0; n < N; n++) {
			
			int height = Integer.parseInt(br.readLine()); //빌딩 높이
			
			while(!stack.isEmpty()) {
				
				int peek = stack.peek(); //최고점 체크
				
				if(peek <= height) {
					//지금 빌딩이 더 크면,
					stack.pop();
				} else break;
			}
			
			sum += stack.size();
			
			//비어있으면
			stack.push(height);
		}
		
		System.out.println(sum);
	}
}