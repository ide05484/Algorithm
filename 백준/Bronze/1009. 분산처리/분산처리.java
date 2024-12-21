import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); //테케개수
		
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= T; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken()); //밑
			int b = Integer.parseInt(st.nextToken()); //지수
			
			a %= 10;
			
			if(a == 0) {
				sb.append(10).append("\n");
				continue;
			}
			
			int[] data = new int[4]; //최대 4번반복
			
			data[0] = a;
			
			for(int i = 1; i < 4; i++) {
				data[i] = (data[i-1] * a) % 10;
			}
			
			int idx = b % 4 - 1;
			if(idx == -1) idx = 3;
			
			sb.append(data[idx]).append("\n");

		}
		
		System.out.println(sb);
	}
}