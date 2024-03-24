import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N; // 여기에서
	static int M; // M개 구하기

	static int[] arr; // 자연수 배열
	static boolean[] sel; // 선택배열
	static int[] answer; // 정답배열

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		answer = new int[M];
		sel = new boolean[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); // 자연수 넣어주기
		}

		Arrays.sort(arr); // 사전순 정렬 해줘야 사전순으로 나온다.

		comb(0, 0);
		System.out.println(sb);

	}

	// num은 고려하는 재료 종류, idx는 선택하는 재료 인덱스
	private static void comb(int num, int idx) {

		if (idx >= M) { // 재료를 다 채우면 일단 리턴

			for (int i = 0; i < M; i++) {
				sb.append(answer[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		//다 선택햇을 때를 고려해줘야함 (num이 추가되면!)
		if(num >= N) {
			return;
		}

		// 선택했을 때
		sel[num] = true;
		answer[idx] = arr[num];
		comb(num + 1, idx + 1);

		sel[num] = false; // 안선택했을대
		comb(num + 1, idx);
	}
}