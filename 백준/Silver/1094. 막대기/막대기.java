import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int X = Integer.parseInt(br.readLine()); // 막대기 길이
		int answer = 0;

		// 64는 2의 6승, 1까지하면 7개의 칸이 필요하다
		for (int i = 0; i < 7; i++) {
			if ((X & (1 << i)) > 0)
				//1씩 배열을 땡겨가면서 X의 비트가 1인지를 확인하겠다 (&)
				answer++;
		}
		
		System.out.println(answer);
	}
}