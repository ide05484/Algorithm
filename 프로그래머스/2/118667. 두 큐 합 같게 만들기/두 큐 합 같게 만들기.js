function solution(queue1, queue2) {
    let answer = 0;
    
    let queueSum1 = 0;
    queue1.forEach((element) => queueSum1 += element);
    
    let queueSum2 = 0;
    queue2.forEach((element) => queueSum2 += element);
    
    let len = queue1.length + queue2.length;
    
    let queueIdx1 = 0;
    let queueIdx2 = 0;
    
    while(queueSum1 !== queueSum2) {
        if(queueIdx1 > len || queueIdx2 > len) return -1; //절대안됨
        
        if(queueSum1>queueSum2){
            queueSum1 -= queue1[queueIdx1];
            queue2.push(queue1[queueIdx1]);
            queueSum2 +=queue1[queueIdx1++];
        } else{
             queueSum1 += queue2[queueIdx2];
             queue1.push(queue2[queueIdx2]);
             queueSum2 -=queue2[queueIdx2++];
        }
        
        answer++;
    }
    
    return answer;
}