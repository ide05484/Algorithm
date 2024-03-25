import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] arr;
	static int[] sort;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		arr = new int[N]; // 받을 배열

		for (int n = 0; n < N; n++) {
			arr[n] =Integer.parseInt(br.readLine()); // 숫자 넣어주기
		}
		
		sort = new int[N]; //정리될 배열
		
		mergeSort(0, N - 1);
		
		StringBuilder sb = new StringBuilder();

		for (int n = 0; n < N; n++) {
			sb.append(arr[n] + "\n");
		}
		
		System.out.println(sb);

	}

	private static void mergeSort(int left, int right) {

		if (left < right) {
			int mid = (left + right) / 2;

			mergeSort(left, mid);
			mergeSort(mid + 1, right);

			merge(left, mid, right);
		}
	}

	private static void merge(int left, int mid, int right) {
		int L = left;
		int R = mid + 1;

		int idx = left; // sort 배열을 돌기 위함

		while (L <= mid && R <= right) {
			if (arr[L] <= arr[R]) { // 오른쪽이 더 크면
				sort[idx++] = arr[L++];
			} else { // 그렇지 않다면 반대로
				sort[idx++] = arr[R++];

			}
		}

		// 다 돌고 나면 한쪽 배열이 남는다!
		// 왼쪽 배열이 남앗다면?
		while (L <= mid) {
			sort[idx++] = arr[L++];
		}
		// 오른쪽이 남앗다면?
		while (R <= right) {
			sort[idx++] = arr[R++];
		}

		// 그러고 나면 결과를 저장해야함
		for (int i = left; i <= right; i++) {
			arr[i] = sort[i];
		}

	}
}