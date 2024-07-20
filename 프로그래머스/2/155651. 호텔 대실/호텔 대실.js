function solution(book_time) {
    
    
    
    // 시간을 분으로 변환하는 함수
    const timeToMinutes = (time) => {
        const [hour, minute] = time.split(":").map(Number); //타입변환
        return hour * 60 + minute;
    };
    
     const rooms = [];

    // 예약 정보를 이벤트로 변환
    book_time.forEach(([start, end]) => {
        const startTime = timeToMinutes(start);
        const endTime = timeToMinutes(end) + 10; // 청소 시간 10분 포함
        
        rooms.push({ time: startTime, type: 'start' });
        rooms.push({ time: endTime, type: 'end' });
    });

    // 시간 기준으로 이벤트 정렬 (같은 시간의 경우 'end' 이벤트가 먼저 처리되도록)
    rooms.sort((a, b) => a.time - b.time || a.type.localeCompare(b.type));
    
    let currentRooms = 0;
    let maxRooms = 0;

    // 이벤트 처리
    rooms.forEach(room => {
        if (room.type === 'start') {
            currentRooms += 1;
            maxRooms = Math.max(maxRooms, currentRooms);
        } else if (room.type === 'end') {
            currentRooms -= 1;
        }
    });

    return maxRooms;
    

//     // 각 예약의 시작 시간과 종료 시간을 분 단위로 변환
//     const times = book_time.map(([start, end]) => [timeToMinutes(start), timeToMinutes(end)]);

//     // 시작 시간이 빠른 순서로 정렬
//     times.sort((a, b) => a[0] - b[0]);
    

//     const rooms = [];

//     for (const [start, end] of times) {
//         let placed = false;
        
//         // 각 방을 확인하여 현재 예약을 넣을 수 있는지 확인
//         for (let i = 0; i < rooms.length; i++) {
//             if (rooms[i] <= start) {
//                 // 현재 방에 새 예약 배정 (기존 예약 종료 시간 + 청소 시간)
//                 rooms[i] = end + 10;
//                 placed = true;
//                 break;
//             }
//         }

//         // 현재 예약을 배정할 방이 없으면 새로운 방 추가
//         if (!placed) {
//             rooms.push(end + 10);
//         }
//     }

//     // 필요한 방의 개수 반환
//     return rooms.length;
}
