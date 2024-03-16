import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int N = Integer.parseInt(br.readLine()); // 주어지는 숫자

		int[] num = new int[N];

		for (int n = 0; n < N; n++) {
			num[n] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(num);
		
		StringBuilder sb = new StringBuilder();
		
		for(int n = 0 ; n<N; n++) {
			sb.append(num[n]+"\n");
		}
		
		System.out.println(sb);
	}
}