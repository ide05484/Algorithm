import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] find;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 주어진 배열의 수
		find = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int n = 0; n < N; n++) {
			find[n] = Integer.parseInt(st.nextToken()); // 배열에 넣어줌
		}

		Arrays.sort(find); // 이진탐색을 하기 위해 넣음

		int M = Integer.parseInt(br.readLine()); // 찾아야하는 원소의 수
		st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int m = 0; m < M; m++) {
			int num = Integer.parseInt(st.nextToken()); // 주어지는 숫자

			if (binarySearch(num)) { // 하나라도 있다?
				sb.append(1 + "\n");
				continue;
			}
			// 다 돌때까지 없었어??
			sb.append(0 + "\n");
		}
		System.out.println(sb);
	}

	private static boolean binarySearch(int num) {

		int left = 0;
		int right = find.length - 1; // 끝에서 -1

		while (left <= right) {
			int mid = (left + right) / 2; // 중간지점

			if (find[mid] == num) {
				return true;
			} else if (find[mid] < num) { //num이 중간보다 큰 오른쪽에 있다는 뜻
				left = mid + 1;
			} else { //num이 중간보다 큰 오른쪽에 있다는 뜻
				right = mid - 1;
			}
		}

		return false;
	}
}
