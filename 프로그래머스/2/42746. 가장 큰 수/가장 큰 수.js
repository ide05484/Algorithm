function compare(a, b) {
    if (a + b > b + a) {
        return -1;
    } else if (a + b < b + a) {
        return 1;
    } else {
        return 0;
    }
}

function solution(numbers) {
    // 숫자를 문자열로 변환
    numbers = numbers.map(String);
    
    // 비교 함수를 사용하여 정렬
    numbers.sort(compare);
    
    // 정렬된 숫자들을 이어 붙임
    const result = numbers.join('');
    
    // 숫자가 0으로 시작하면 0을 반환
    return result[0] === '0' ? '0' : result;
}