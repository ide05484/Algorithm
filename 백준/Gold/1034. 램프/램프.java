import java.util.*;
import java.io.*;

public class Main {

	static int N, M, K, max;
	static int[][] lamp;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		lamp = new int[N][M];

		List<String> patterns = new ArrayList<>();

		for (int r = 0; r < N; r++) {
			String str = br.readLine();
			patterns.add(str);
			for (int c = 0; c < M; c++) {
				lamp[r][c] = str.charAt(c) - '0';
			}
		}

		K = Integer.parseInt(br.readLine());
		max = 0;

		findMaxRows(patterns);

		System.out.println(max);
	}

	// 같은 패턴을 가진 행 세기
	private static void findMaxRows(List<String> patterns) {

	    HashMap<String, Integer> patternCount = new HashMap<>();

	    // 같은 패턴을 가진 행 개수를 저장
	    for (String pattern : patterns) {
	        patternCount.put(pattern, patternCount.getOrDefault(pattern, 0) + 1);
	    }

	    // 각 패턴에 대해 가능한지 검사
	    for (String pattern : patternCount.keySet()) {
	        int zeroCount = 0;

	        // 패턴 내에서 0의 개수 세기
	        for (char ch : pattern.toCharArray()) {
	            if (ch == '0') zeroCount++;
	        }

	        // 1) 0의 개수 <= K (스위치 누를 수 있는 횟수 내에서 모든 0을 1로 만들 수 있는가?)
	        // 2) (K - zeroCount) % 2 == 0 (K번 누르면 원래 상태 유지 가능해야 함)
	        if (zeroCount <= K && (K - zeroCount) % 2 == 0) {
	            max = Math.max(max, patternCount.get(pattern));
	        }
	    }
	}
}
