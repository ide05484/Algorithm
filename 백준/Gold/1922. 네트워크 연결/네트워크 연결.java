import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class Computer implements Comparable<Computer> {
		int start, end, cost;

		public Computer(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Computer o) {
			return this.cost - o.cost;
		} // 비용으로 정렬하기 위함
	}

	static int[] top; // 대표배열

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
		int M = Integer.parseInt(br.readLine()); // 연결할 수 잇는 선의 수

		Computer[] computers = new Computer[M]; // 컴퓨터 연결해

		for (int c = 0; c < M; c++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			computers[c] = new Computer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(computers); // 최소를 구하기 위해서 정렳둘 필요있음

		top = new int[N + 1]; // 컴퓨터 수 만큼의 대표 (1번부터 시작하네요)

		for (int t = 0; t < N + 1; t++) {
			top[t] = t;
		}

		int cost = 0; // 최소비용
		int count = 0; // 간선 최소수는 N-1개

		for (int m = 0; m < M; m++) {
			// 모든 간선을 돌면서 대표찾아 대표찾아
			int topX = findset(computers[m].start);
			int topY = findset(computers[m].end);

			if (topX != topY) { // 대표가 다르다면 연결해줄 테니 = 같은 대표는 연결해봐야 소용 없다
				union(topX, topY); // 합쳐주고
				cost += computers[m].cost;
				count++;
			}

			if (count == N - 1)
				break; // 멈춰멈춰
		}

		System.out.println(cost);
	}

	private static void union(int topX, int topY) {
		//왼쪽 기준으로 합치자
		top[topY] = topX;
	}

	private static int findset(int me) {

		if (top[me] != me) { // 내 대표가 내가 아니면 최고 대표 찾아 떠나
			top[me] = findset(top[me]); //타고타고 가서 같을때가지 가!
		}
		return top[me];
	}
}