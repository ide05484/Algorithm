import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N; // 여기에서
	static int M; // M개 구하기

//	static int[] arr; // 자연수 배열
	static int[] answer; // 정답배열
	static StringBuilder sb= new StringBuilder();

	public static void main(String[] args) throws IOException {
		
		//시간초과 떴ㄷ ㅏ. ..
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

//		arr = new int[N];
		answer = new int[M];

//		for (int i = 0; i < N; i++) {
//			arr[i] = i + 1; // 자연수 넣어주기
//		}

		comb(0);
		System.out.println(sb);

	}

	// num은 고려하는 재료 종류, idx는 선택하는 재료 인덱스
	private static void comb(int idx) {
		
		if (idx >= M) { // 재료를 다 채우면 일단 리턴

			for (int i = 0; i < M; i++) {
				sb.append(answer[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		//중복까지 계산하니까 그냥 돌리자!
		for (int i = 0; i < N; i++) {
				answer[idx] = i+1;
				comb(idx + 1);
		}
	}
}