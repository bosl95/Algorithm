import sys
input=sys.stdin.readline

dx = [0, -1, 0, 1]
dy = [-1, 0, 1, 0]

def solution(n, m, r, c, d, place):
    ans, visit = 1, [[0]*m for _ in range(n)]
    visit[r][c] = 1
    stack = [(r, c, d)]
    while True:
        x, y, d_ = stack.pop()
        for i in range(4, -1, -1):
            d__ = (d_+i)%4          # 현재 회전한 위치에서의 서쪽
            mx, my = x+dx[d__], y+dy[d__]
            if 0<=mx<n and 0<=my<m:
                if place[mx][my]==0 and visit[mx][my]==0:
                    visit[mx][my]=1
                    d__ = 3 if d__==0 else d__-1
                    stack.append((mx, my, d__))
                    ans += 1
                    break
        if not stack:
            i = (d_+3)%4
            mx, my = x+dx[i], y+dy[i]
            if 0<=mx<n and 0<=my<m and place[mx][my]==0:
                stack.append((mx, my, d_))
            else:
                return ans

N, M = map(int, input().split())
R, C, D = map(int, input().split())
Place = [list(map(int, input().split())) for _ in range(N)]
print(solution(N, M, R, C, D, Place))
