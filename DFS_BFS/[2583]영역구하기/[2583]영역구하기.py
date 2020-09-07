import sys; input=sys.stdin.readline
n, m, k = map(int, input().split())
xy= [ list(map(int, input().split())) for _ in range(k) ]
loc = [[0]*m for _ in range(n)]

for x1, y1, x2, y2 in xy:
    for i in range(y1, y2):
        for j in range(x1, x2):
            loc[i][j] = 1

def dfs(loc, start, n, m, visit):
    cnt = 0
    stack = [start]
    while stack:
        i, j = stack.pop()
        cnt += 1
        loc[i][j] = 1
        for x, y in (1, 0), (-1, 0), (0, 1), (0, -1):
            mx = i + x
            my = j + y
            if 0<=mx<n and 0<=my<m and loc[mx][my]==0 and visit[mx][my]==0:
                stack.append((mx, my))
                visit[mx][my] = 1
    return cnt

def solution(loc, n, m, k):
    area = []
    cnt = 0
    visit = loc.copy()
    for i in range(n):
        for j in range(m):
            if loc[i][j] ==0:
                cnt += 1
                area.append(dfs(loc, (i, j), n, m, visit))
    return [cnt, area]

result = solution(loc, n, m, k)
print(result[0])
result[1].sort()
print(*result[1])