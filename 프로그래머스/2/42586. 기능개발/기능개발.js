function solution(progresses, speeds) {
    
    let day = 0;
    
    let finish = [];
    
    while(progresses.length !== 0){
        //작업이 남아 있지 않을 때까지
        day++; //하루지남   
        
        for(let i = 0; i < progresses.length; i++) {
            progresses[i] += speeds[i];
        }
               
        let count = 0; //끝낼 일
    
        //첫타자가 완료된다면
        while(progresses[0] >= 100) {
            progresses.shift();
            speeds.shift();
            count++;
        }
        finish.push(count);
    }
     
    return finish.filter((progress) => progress !== 0);
}