import java.awt.Point;

class Solution {
    
    static int max; //최대 던전수
    
    public int solution(int k, int[][] dungeons) {
        // 순열로 순서를 만든 후 모든 탐색 갈기자
		boolean[] visit = new boolean[dungeons.length];
		
		Point[] select = new Point[dungeons.length]; // 던전을 돌 순서 배열
		max = 0;
		perm(k, dungeons, visit, 0, select);

		return max;
    }
    
    private static void perm(int k, int[][] dungeons, boolean[] visit, int idx, Point[] select) {
		if (idx == select.length) {
			// 순열을 만들었다면 여기서 계산
			go(k, select);
			return;
		}
		
		for (int r = 0; r < dungeons.length; r++) {
			//던전순서를 정하자
			if(!visit[r]) {
				//방문안했다면, 그곳 방문쳌
				visit[r] = true;
				select[idx] = new Point(dungeons[r][0], dungeons[r][1]);
				perm(k, dungeons, visit, idx+1, select);
				
				//다시 나올때 원복
				visit[r] = false;
			}
		}
	}

	private static void go(int k, Point[] select) {
		
		int count = 0;
		
		for(int i = 0; i < select.length; i++) {
			if(select[i].x <= k) {
				//들어갈 수 있는 최소 피로도
				count++;
				k -= select[i].y; //소모된거만큼 뺴준다
			}
		}
		
		max = Math.max(max, count);
	}
}