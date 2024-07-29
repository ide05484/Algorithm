function solution(board, moves) {
    
    let stack = []; //스택 바구니
    
    let answer = 0;
    
    for(let move of moves) {
        const idx = move-1; //현재 줄
        
       for (let i = 0; i < board.length; i++) {
            if (board[i][idx] !== 0) {
            
                let doll = board[i][idx];
            board[i][idx] = 0; //뺏으니까 바꿈
            stack.push(doll);
        
        if(stack.length >= 2 && stack[stack.length - 1] === stack[stack.length -2]) {
            stack.pop();
            stack.pop(); //두개 다 없애줌
            answer += 2;
        }
                // console.log(stack)
         break; //if 찾아서 했으면 멈춰!
        }
       }
    }
    
    return answer;
}