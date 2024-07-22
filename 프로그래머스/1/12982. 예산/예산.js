function solution(d, budget) {
    
    d.sort((a,b) => a-b);
    
    let count = 0;
    let max = budget;
    
    for(let i = 0; i < d.length; i++) {
        max -= d[i];
               
        if(max < 0) break; //예산초과시 멈춰!
        //아니라면
        count++;
    }

    return count;
}