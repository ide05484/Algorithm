class Solution {
    public int solution(String[] board) {
        
        char[][] game = new char[3][3];
        
        for(int r = 0; r < 3; r++) {
            String str = board[r];
            for(int c = 0; c < 3; c++) {
                game[r][c] = str.charAt(c);
            }
        }
        //게임 상황을 받음
        
        int canGame = 1; //게임할 수 있는가 없는가
        //할 수 있는 게 1, 없는 게 0
        
        int countO = 0; //O의 개수
        int countX = 0; //X의 개수
        
        for(int r = 0; r < 3; r++) {
            for(int c = 0; c < 3; c++) {
                if(game[r][c] == 'O') {
                    countO++;
                } else if(game[r][c] == 'X') countX++;
            }
        }
        
        boolean winO = false;
        boolean winX = false;

        // 가로 체크
        for(int r = 0; r < 3; r++) {
            if(game[r][0] != '.' && game[r][0] == game[r][1] && game[r][1] == game[r][2]) {
                if(game[r][0] == 'O') winO = true;
                if(game[r][0] == 'X') winX = true;
            }
        }

        // 세로 체크
        for(int c = 0; c < 3; c++) {
            if(game[0][c] != '.' && game[0][c] == game[1][c] && game[1][c] == game[2][c]) {
                if(game[0][c] == 'O') winO = true;
                if(game[0][c] == 'X') winX = true;
            }
        }

        // 대각선 체크
        if(game[0][0] != '.' && game[0][0] == game[1][1] && game[1][1] == game[2][2]) {
            if(game[0][0] == 'O') winO = true;
            if(game[0][0] == 'X') winX = true;
        }
        if(game[0][2] != '.' && game[0][2] == game[1][1] && game[1][1] == game[2][0]) {
            if(game[0][2] == 'O') winO = true;
            if(game[0][2] == 'X') winX = true;
        }

        // 게임 조건 검증
        if((winO && winX) || (winO && countO != countX + 1) || (winX && countO != countX)) {
            canGame = 0;
        } else if(!(countO == countX || countO == countX + 1)) {
            canGame = 0;
        }
        
        
        return canGame;
    }
}