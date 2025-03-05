import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int num = ~N + 1;
		
		//XOR 연산
		int answer = N ^ num;
		
		int count = Integer.bitCount(answer);
		
		System.out.println(count);
	}
}