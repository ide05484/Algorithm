function solution(phone_book) {
    // 전화번호 배열을 정렬합니다.
    phone_book.sort();

    // 정렬된 배열에서 인접한 전화번호를 비교합니다.
    for (let i = 0; i < phone_book.length - 1; i++) {
        // 현재 번호가 다음 번호의 접두사인지 확인합니다.
        if (phone_book[i + 1].startsWith(phone_book[i])) {
            return false;
        }
    }

    return true;
}