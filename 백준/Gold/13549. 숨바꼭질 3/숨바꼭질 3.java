import java.util.*;
import java.io.*;

public class Main {

	static class Here {
		int now;
		int time;

		public Here(int now, int time) {
			this.now = now;
			this.time = time;
		}
	}

	static int[] dx = { -1, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 수빈이가 있는 위치
		int K = Integer.parseInt(st.nextToken()); // 동생이 있는 위치

		int[] dist = new int[100001]; // 방문했나요

		Arrays.fill(dist, Integer.MAX_VALUE);

		// 타임이 적은 순
		PriorityQueue<Here> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.time, o2.time));

		queue.add(new Here(N, 0)); // 시작 지점 넣기
		dist[N] = 0;

		while (!queue.isEmpty()) {
			Here here = queue.poll();

			// 동생 위치를 잡았다면
			if (here.now == K) {
				System.out.println(here.time);
				return;
			}

			int nowPos = here.now;

			if (nowPos * 2 <= 100000 && here.time < dist[nowPos * 2]) {
				dist[nowPos * 2] = here.time;
				queue.add(new Here(nowPos * 2, here.time));
			}

			// 걷기 (-1, +1 이동, 1초 추가)
			if (nowPos - 1 >= 0 && here.time + 1 < dist[nowPos - 1]) {
				dist[nowPos - 1] = here.time + 1;
				queue.add(new Here(nowPos - 1, here.time + 1));
			}
			
			if (nowPos + 1 <= 100000 && here.time + 1 < dist[nowPos + 1]) {
				dist[nowPos + 1] = here.time + 1;
				queue.add(new Here(nowPos + 1, here.time + 1));
			}
		} // queue 끝
	}
}