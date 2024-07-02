function solution(num_list) {
    
    let even = ' ';
    let notEven = ' ';
    
    for(num of num_list) {
        num % 2== 0 ? even+=String(num) : notEven+=String(num);
    }
    
    return Number(even)+Number(notEven);
}