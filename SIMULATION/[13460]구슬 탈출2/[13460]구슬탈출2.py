import sys
from collections import deque

input=sys.stdin.readline

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

def move(x, y, i, j):
    count = 0
    while Board[x+i][y+j] != '#' and Board[x][y] != 'O':
        x += i
        y += j
        count += 1
    return x, y, count


def solution(n, m, board, r, b):
    q = deque([[r[0], r[1], b[0], b[1], 1]])
    while q:
        rx, ry, bx, by, cnt = q.popleft()
        if cnt>10: break
        for i in range(4):
            mrx, mry, rc = move(rx, ry, dx[i], dy[i])
            mbx, mby, bc = move(bx, by, dx[i], dy[i])
            if Board[mbx][mby] != "O":
                if Board[mrx][mry] == "O":
                    print(cnt)
                    return
                if mrx == mbx and mry == mby:
                    if rc > bc :    # 빨간 구슬이 파란 구슬보다 이동해야하는 거리로부터 멀다 (= 떨어지는 위치로부터 더 떨어져있다.)
                        mrx -= dx[i]
                        mry -= dy[i]    # 전 단계로 이동
                    else:
                        mbx -= dx[i]
                        mby -= dy[i]
                if not visit[mrx][mry][mbx][mby] and cnt < 10:
                    visit[mrx][mry][mbx][mby] = True

                    q.append([mrx, mry, mbx, mby, cnt+1])
    print(-1)


N, M = map(int, input().split())
Board = []; R, B = [0, 0], [0, 0]
for i in range(N):
    tmp = list(input().strip())
    for j in range(M):
        if tmp[j] == 'R':
            R = [i, j]
        elif tmp[j] == 'B':
            B = [i, j]
    Board.append(tmp)
visit = [[[[False]*M for _ in range(N)] for _ in range(M)] for _ in range(N)]
solution(N, M, Board, R, B)