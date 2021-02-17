def solution(n, horizontal):
    answer = [[0]*n for _ in range(n)]
    # 0 : 오른쪽 1 : 왼쪽 대각선 아래 2 : 아래 3 : 오른쪽 대각선 위
    turn = 0 if horizontal else 2
    x, y = 0, 0
    cnt = 0
    answer[0][0] = 0

    while True:
        # 만약 y == n-1이면 밑으로 그냥 내려감
        # 만약 x == n-1 이면 오른쪽으로 감
        if turn == 0:   # 오른쪽으로 이동
            cnt += 1
            if y==n-1: x+=1
            else:   y += 1
            answer[x][y] = cnt
            turn +=1
        elif turn == 1:     # 왼쪽 대각선 아래
            cnt += 2
            x += 1
            y -= 1
            if y == 0 or x == n-1: turn += 1
            answer[x][y] = cnt
        elif turn == 2:     # 아래
            cnt += 1
            if x == n-1: y += 1
            else: x += 1
            answer[x][y] = cnt
            turn += 1
        elif turn == 3:     # 오른쪽 대각선 위
            cnt += 2
            x -= 1
            y += 1
            answer[x][y] = cnt
            if x == 0 or y == n - 1: turn = 0

        if x==n-1 and y==n-1: break
    return answer

# print(solution(4, True))
# print(solution(5, False))
# print(solution(2, True))
print(solution(3, False))