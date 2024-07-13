function solution(s, skip, index) {
    
    //알파벳은 26개...
    let alphabet = ['a', 'b', 'c', 'd', 'e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'];
    
    const check = (idx) => {
       return skip.includes(alphabet[idx])
    }
    
        let answer = '';
    
    for(let i = 0; i < s.length; i++){
        let idx = alphabet.indexOf(s.charAt(i));
        let count = index;
        
        while(count !== 0){
            //0이 될때까지
            idx = (idx + 1) % 26;
            if(!check(idx)) {
                //skip에 없다면
                count--;
            }
        }
        
        answer+=alphabet[idx % 26];
    }
    
    return answer;
}