import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	// 연결된 길
	static class Road implements Comparable<Road> {
		int start, end, cost;

		public Road(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Road o) {
			return this.cost - o.cost;
		}
	}

	static int[] top; // 대표배열

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 집개수
		int M = Integer.parseInt(st.nextToken()); // 길개수

		Road[] roads = new Road[M]; // 길개수

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			roads[m] = new Road(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		} // 입력끝

		Arrays.sort(roads);

		top = new int[N + 1]; // 1번집부터 시작

		for (int n = 1; n <= N; n++) {
			top[n] = n;
		}
		
		int cost = 0;
		int max = 0; //유지비는 최소 1부터
		int count = 0;

		for (int m = 0; m < M; m++) {
			//모든 간선 돌게유
			int topX = findset(roads[m].start);
			int topY = findset(roads[m].end);
			
			//얘네가 안이어져잇다 = 대표가 다르다
			if(topX != topY) {
				union(topX, topY);
				cost += roads[m].cost;
				max = Math.max(max, roads[m].cost); //연결할 때 최대 도로 비용 생각하기 집은 최소 하나만 있어도 마을로 인정된다고함
				count++;
			}
			
			if(count == N-1) break; //최소간선채우면 멈춰
		}
		
		System.out.println(cost - max);

	}

	private static void union(int topX, int topY) {
		top[topY] = topX; //왼쪽기준
	}

	private static int findset(int me) {
		
		if(top[me] != me) {
			return top[me] = findset(top[me]); //타고가서 걔로 바꿔
		}
		
		return top[me]; //같으면 그거그냥 반환
	}
}