import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class Road implements Comparable<Road> {
		int start, end, cost;

		public Road(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		public int compareTo(Road o) {
			return this.cost - o.cost;
		}
	}

	static int[] top; // 대표배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken()); // 집의 개수
			int M = Integer.parseInt(st.nextToken()); // 길의 개수

			if (N == 0 && M == 0) //입력이 여러개 들어오고 맨 끝에 0 0 이 들어오면 멈춰주세오 임
				break;

			Road[] roads = new Road[M]; // 길의 개수 배열

			int sum = 0; // 지금 현재 쓰고 있는 전력

			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				roads[m] = new Road(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));

				sum += roads[m].cost;
			}

			Arrays.sort(roads);

			top = new int[N]; // 0번 집부터 잇음요

			for (int n = 0; n < N; n++) {
				top[n] = n;
			}

			int cost = 0; // 최소비용
			int count = 0; // 간선수

			for (int m = 0; m < M; m++) {
				int topX = findset(roads[m].start);
				int topY = findset(roads[m].end);

				if (topX != topY) {
					union(topX, topY);
					count++;
					cost += roads[m].cost;
				}

				if (count == N - 1)
					break;
			}

			System.out.println(sum - cost);
		}
	}

	private static void union(int topX, int topY) {
		top[topY] = topX;
	}

	private static int findset(int me) {

		if (top[me] != me) {
			return top[me] = findset(top[me]);
		}

		return top[me];
	}
}