function solution(numbers, hand) {
    
    //키패드
    const keypad = {
        1: [0, 0], 2: [0, 1], 3: [0, 2],
        4: [1, 0], 5: [1, 1], 6: [1, 2],
        7: [2, 0], 8: [2, 1], 9: [2, 2],
        '*': [3, 0], 0: [3, 1], '#': [3, 2]
    };
    
    let answer = [];
    
    let leftHand = keypad['*'];
    let rightHand = keypad['#'];
    
    for(let num of numbers) {
        if([1,4,7].includes(num)) {
            answer.push('L');
            leftHand = keypad[num];
        }
        else if([3,6,9].includes(num)) {
            answer.push('R');
            rightHand = keypad[num];
        } else {
            let leftDist = Math.abs(leftHand[0] - keypad[num][0]) + Math.abs(leftHand[1] - keypad[num][1]);
            let rightDist = Math.abs(rightHand[0] - keypad[num][0]) + Math.abs(rightHand[1] - keypad[num][1]);
            
            if(leftDist < rightDist) {
                answer.push('L');
                leftHand=keypad[num];
            } else if (leftDist > rightDist) {
                answer.push('R');
                rightHand=keypad[num];
            } else {
                //같은 경우
                if(hand === 'left') {
                    answer.push('L');
                leftHand=keypad[num];
                } else {
                      answer.push('R');
                      rightHand=keypad[num];
                }
            }
        }
    } //for문 끝
    
    
    
    return answer.join('');
}