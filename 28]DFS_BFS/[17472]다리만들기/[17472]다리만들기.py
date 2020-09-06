import sys
from collections import deque

input = sys.stdin.readline
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def bfs(i, j, num, visit):
    stack = deque([(i, j)])

    visit[i][j] = num
    tmp = set()
    while stack:
        x, y = stack.popleft()
        for k in range(4):
            mx = x + dx[k]
            my = y + dy[k]
            if 0<=mx<N and 0<=my<M and visit[mx][my]==0:
                if Land[mx][my] == 1:
                    visit[mx][my] = num
                    stack.append((mx, my))
                elif Land[mx][my] == 0:
                    tmp.add((x, y))
    return tmp

def bfs2(sets, cnt, n, m):
    # print(sets)
    stack = deque(sets)
    result = set()
    visit2 = [[0]*m for _ in range(n)]

    while stack:
        tmp = []
        s = len(stack)
        for i in range(4):
            for j in range(s):
                x, y = map(int, stack[j])
                mx = x + dx[i]
                my = y + dy[i]
                if 0<=mx<n and 0<=my<m and Land[mx][my] != cnt:
                    if Land[mx][my] == 0:
                        visit2[mx][my] = visit2[x][y] + 1
                        tmp.append((mx, my))
                    else:
                        result.add((cnt, Land[mx][my], visit2[x][y]))
        if tmp:
            print(tmp)
            stack.extend(*(tmp.copy()))

    return result

def solution(n, m, land):
    visit = [[0]*M for _ in range(N)]
    cnt = 1
    island = []

    for i in range(n):
        for j in range(m):
            if land[i][j] == 1 and visit[i][j] ==0:
                island.append(bfs(i, j, cnt, visit))
                cnt += 1

    for i in range(cnt):
        print(bfs2(island[i], cnt, n, m))
        input()


N, M = map(int, input().split())
Land = [list(map(int, input().split())) for _ in range(N)]
print(solution(N, M, Land))