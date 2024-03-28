import java.util.Scanner;
 
public class Solution {
    static int N;
    static int[][] arr;
    static boolean[] visit;
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt(); // 테스트 개수
 
        for (int tc = 1; tc <= T; tc++) {
 
            N = sc.nextInt(); // 정점의 개수
            int M = sc.nextInt(); // 간선의 개수
 
            arr = new int[N + 1][N + 1]; // 간선정보를 담을 배열
 
            for (int m = 0; m < M; m++) {
 
                int start = sc.nextInt(); // 시작점
                int end = sc.nextInt(); // 끝점
 
                arr[start][end] = arr[end][start] = 1; // 무방향 그래프니까~ 양방향 다 표시표시
            }
 
            visit = new boolean[N + 1];
 
            int answer = 0; // 초기화
            for (int i = 1; i < N + 1; i++) {
                if (!visit[i]) {// 방문한 곳은 이미 하나의 그래프로 연결 = 하나의 마을
                    DFS(i); // 그래서 방문하지 않은 곳부터 그래프 다시 그려줘~
                    answer++;
                }
            }
            System.out.println("#"+tc+" "+answer);
        }
    }
 
    private static void DFS(int v) {
        // 나 방문처리 해줘
        visit[v] = true;
 
        for (int i = 1; i <= N; i++) {
            if (!visit[i] && arr[v][i] == 1) {
                // 방문 안한 곳중에 연결이 되어 있다면???
                DFS(i); // 계속 타고 가
            }
        }
    }
}