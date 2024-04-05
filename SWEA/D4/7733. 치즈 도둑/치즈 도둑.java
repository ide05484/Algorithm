import java.util.Scanner;
 
public class Solution {
 
    static int[][] cheese;
    static int N;
    static boolean[][] visit; // 방문쳌
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt(); // 테케갯수
 
        for (int tc = 1; tc <= T; tc++) {
 
            N = sc.nextInt(); // 치즈한변의 길이
            cheese = new int[N][N]; // 치즈치즈
 
            int max = 0; // 최대몇일까지 치즈가 생존할 수 있는지 보기
 
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    cheese[r][c] = sc.nextInt();// 맛 입력받기
                    max = Math.max(max, cheese[r][c]);
                }
            }
 
            int maxCount = 1; // 최대 몇덩이 한덩이부터 시작
 
            // 최대일수동안
            for (int i = 1; i <= max; i++) {
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {
                        if (cheese[r][c] == i) {
                            cheese[r][c] = 0; // 파먹는다
                        }
                    }
                } // 돌면서 다 파먹음
 
//              for (int r = 0; r < N; r++) {
//                  for (int c = 0; c < N; c++) {
//                      System.out.print(cheese[r][c] + " ");
//                  }
//                  System.out.println();
//              }
//
//              System.out.println("------------------------------");
 
                // 그리도 해당 날에 덩어리 몇개인지 세기
                visit = new boolean[N][N]; // 방문 체크 배열
                // 여기에 방문체크 초기화해주는 이유는 먹히고 나서 다시 덩어리를 체크해주기 위함
 
                int count = 0;
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {
                        if (!visit[r][c] && cheese[r][c] != 0) { // 방문하지 않은 곳 + 먹히지 않았다면?
                            DFS(r, c); // 그곳부터 덩어리크기 체크
                            count++; // 끝나고 나오면 ++
                        }
                    }
                }
 
                maxCount = Math.max(maxCount, count); // 최대값 갱신
            }
 
            System.out.println("#" + tc + " " + maxCount);
 
        } // 테케
    }// main
 
    private static void DFS(int r, int c) {
        // 범위를 벗어나거나 먹혀있는곳이라면
        if (r < 0 || r >= N || c < 0 || c >= N || cheese[r][c] == 0) {
            return;
        }
 
        if (!visit[r][c]) { //방문하지 않았다면?
 
            visit[r][c] = true; // 방문췤
 
            DFS(r + 1, c);
            DFS(r, c + 1);
            DFS(r - 1, c);
            DFS(r, c - 1);
        }
 
    }
}