function solution(topping) {
    
    const len = topping.length;
    
    let count = 0;
    
    let roll1 = new Set();
    let roll2 = new Map();
    
    for(let i = 0; i < len; i++) {
        roll2.set(topping[i], (roll2.get(topping[i]) || 0) + 1);
    } //map에 개수 세놓기
    
    for(let i = 0; i < len; i++) {
        roll1.add(topping[i]); //하나추가
        
        roll2.set(topping[i], roll2.get(topping[i]) - 1); //한개 제거
        //뺄게 없을 때는 제거
        if (roll2.get(topping[i]) === 0) {
            roll2.delete(topping[i]);
        }
        
        if(roll1.size === roll2.size) count++;
    }   
    
    
    return count;
}