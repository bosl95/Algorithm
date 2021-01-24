import sys
input = sys.stdin.readline


dx = [0, 0, 1, -1]
dy = [-1, 1, 0, 0]

def check(i, j, idx, arr):
    global res
    if idx == 7:
        res.add(''.join(arr))
        return

    for k in range(4):
        mi = i + dx[k]
        mj = j + dy[k]
        if 0<=mi<4 and 0<=mj<4:
            arr.append(board[mi][mj])
            check(mi, mj, idx+1, arr)
            arr.pop()

def solution():
    global res
    res = set()
    for i in range(4):
        for j in range(4):
            check(i, j, 1, [board[i][j]])
    return len(res)

T = int(input().strip())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    board = [list(input().strip().split()) for _  in range(4) ]
    print("#{} {}".format(test_case, solution()))