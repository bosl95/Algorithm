def solution(n, board):
    answer = 1
    stack = [(0, 0)]
    dx = [0, 1, -1, 0]
    dy = [-1, 0, 0, 1]
    num = 1

    while True:
        tmp = set()
        flag = True
        print(stack)
        while stack:
            x, y = stack.pop()
            for i in range(4):
                mx = x+dx[i]
                if mx < 0: mx = n-1
                elif mx > n-1: mx = 0
                my = y+dy[i]
                if my < 0: my = n-1
                elif my > n-1: my = 0
                if board[mx][my] == num:
                    stack = [(mx, my)]
                    answer += 1  # 엔터
                    if num == n*n: return answer
                    num += 1
                    flag = False
                    break
                else:
                    tmp.add((mx, my))
            if not flag: break
        if flag:        # 위치를 찾았다면 그 자리부터 다시 시작
            stack = list(tmp)
        answer += 1

    return answer

print(solution(3,[[3, 5, 6], [9, 2, 7], [4, 1, 8]]))
print(solution(4, [[11, 9, 8, 12], [2, 15, 4, 14], [1, 10, 16, 3], [13, 7, 5, 6]]	))
print(solution(2, [[2, 3], [4, 1]]	))