import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 포켓몬
		int M = Integer.parseInt(st.nextToken()); // 문제

		Map<Integer, String> pocketmon = new HashMap<>();
		Map<String, Integer> pocketmon2 = new HashMap<>();

		for (int n = 1; n <= N; n++) {
			String name = br.readLine();

			pocketmon.put(n, name);
			pocketmon2.put(name, n);
		}

		StringBuilder sb = new StringBuilder();

		for (int m = 0; m < M; m++) {
			String quiz = br.readLine();

			if (quiz.charAt(0) > 57) {
				sb.append(pocketmon2.get(quiz)).append("\n");
			} else {
				sb.append(pocketmon.get(Integer.parseInt(quiz))).append("\n");
			}
		}

		System.out.println(sb);

	}
}