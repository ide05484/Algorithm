import java.util.Scanner;

public class Main {

	static int[] arr;
	static int[] sort;

	static int K;
	private static boolean found = false; // 찾았는가요?

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt(); // 배열 크기
		arr = new int[A];
		sort = new int[A]; // 임시 배열

		K = sc.nextInt(); // 저장횟수

		for (int a = 0; a < A; a++) {
			arr[a] = sc.nextInt(); // 배열 받아줌
		}

		mergeSort(0, A - 1);

		if (!found)
			System.out.println(-1); // 못찾으면 -1

	}

	private static void mergeSort(int left, int right) {

		// 병합정렬을 위한 나누기먼저
		if (left < right) {
			int mid = (left + right) / 2; // 중간지점

			mergeSort(left, mid);
			mergeSort(mid + 1, right);

			merge(left, mid, right); // 병합
		}
	}

	private static void merge(int left, int mid, int right) {

		// 두 구간으로 나누었을 떄 시작점
		int L = left;
		int R = mid + 1;

		int idx = left; // sort 배열을 돌기 위함

		// 둘다 범위 안일 때만 돌아줘~ -> 하나라도 범위가 벗어나면 일단 멈춰 -> 남는거는 알아서 정렬하면 댐
		while (L <= mid && R <= right) {
			if (arr[L] <= arr[R]) { // 오른쪽이 더 크면
				sort[idx++] = arr[L++];
			} else { // 그렇지 않다면 반대로
				sort[idx++] = arr[R++];

			}
			K--;

			if (K == 0) {
				found = true;
				System.out.println(sort[idx - 1]);
				return;
			}
		}

		// 다 돌고 나면 한쪽 배열이 남는다!
		// 왼쪽 배열이 남앗다면?
		while (L <= mid) {
			sort[idx++] = arr[L++];
			K--;
			if (K == 0) {
				found = true;
				System.out.println(sort[idx - 1]);
				return;
			}
		}
		// 오른쪽이 남앗다면?
		while (R <= right) {
			sort[idx++] = arr[R++];
			K--;
			if (K == 0) {
				found = true;
				System.out.println(sort[idx - 1]);
				return;
			}
		}

		// 그러고 나면 결과를 저장해야함
		for (int i = left; i <= right; i++) {
			arr[i] = sort[i];
		}
	}
}