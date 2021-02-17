def solution(numbers, hand):
    answer = ''
    phone = {1:[0, 0], 2: [0, 1], 3:[0, 2], 4:[1, 0], 5:[1, 1], 6:[1, 2], 7:[2, 0], 8:[2, 1], 9:[2,2], 0:[3, 1]}
    lloc, rloc = [3, 0], [3, 2]


    for n in numbers:
        x, y = phone[n]
        left = abs(lloc[0]-x)+abs(lloc[1]-y)
        right = abs(rloc[0]-x)+abs(rloc[1]-y)
        if y == 1:  # 가운데 숫자일 경우
            if left < right:
                pos = 'left'
            elif left > right:
                pos = 'right'
            else:
                pos = hand
        elif y == 0:    # 왼쪽 숫자일 경우
            pos = 'left'
        else:
            pos = 'right'

        if pos == 'left':
            lloc = [x, y]
            answer += 'L'
        else:
            rloc = [x, y]
            answer += 'R'

    return answer

print(solution([1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5], 'right'))