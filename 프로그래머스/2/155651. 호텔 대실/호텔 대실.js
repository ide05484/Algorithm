function solution(book_time) {
    
    // 시간을 분으로 변환하는 함수
    const timeToMinutes = (time) => {
        const [hour, minute] = time.split(":").map(Number); //타입변환
        return hour * 60 + minute;
    };

    // 각 예약의 시작 시간과 종료 시간을 분 단위로 변환
    const times = book_time.map(([start, end]) => [timeToMinutes(start), timeToMinutes(end)]);

    // 시작 시간이 빠른 순서로 정렬
    times.sort((a, b) => a[0] - b[0]);

    const rooms = [];

    for (const [start, end] of times) {
        let placed = false;
        
        // 각 방을 확인하여 현재 예약을 넣을 수 있는지 확인
        for (let i = 0; i < rooms.length; i++) {
            if (rooms[i] <= start) {
                // 현재 방에 새 예약 배정 (기존 예약 종료 시간 + 청소 시간)
                rooms[i] = end + 10;
                placed = true;
                break;
            }
        }

        // 현재 예약을 배정할 방이 없으면 새로운 방 추가
        if (!placed) {
            rooms.push(end + 10);
        }
    }

    // 필요한 방의 개수 반환
    return rooms.length;
}
