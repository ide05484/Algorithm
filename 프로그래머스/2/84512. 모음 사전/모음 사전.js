function solution(word) {
    
    const alphabets = ['A', 'E', 'I', 'O', 'U'];
    
    let words = [];

    function makeWord(current) {
        if (current.length > 5) return; // 길이가 5를 초과하면 종료
        
        if (current.length > 0) words.push(current); // 단어를 추가
        
        for (let i = 0; i < alphabets.length; i++) {
            makeWord(current + alphabets[i]); // 재귀적으로 단어 생성
        }
    }

    makeWord('');

    words.sort(); // 단어들을 사전순으로 정렬
    return words.indexOf(word) + 1; // 인덱스를 반환 (1부터 시작)
}
