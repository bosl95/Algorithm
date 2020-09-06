import sys
from collections import deque

input = sys.stdin.readline
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

def bfs(i, j, num, visit):
    stack = deque([(i, j)])
    visit[i][j] = num
    tmp = [set(), set(), set(), set()]
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
                    tmp[k].add((x, y))
    return tmp

def bfs2(sets, cnt, n, m, visit):
    result = []
    visit3 = [[0]*m for _ in range(n)]

    for i in range(4):
        s = sets[i]
        while s:
            x, y = s.pop()
            mx = x + dx[i]
            my = y + dy[i]
            if 0<=mx<n and 0<=my<m and visit[mx][my] != cnt:
                if visit[mx][my] == 0:
                    visit3[mx][my] = visit3[x][y] + 1
                    s.add((mx, my))
                else:
                    if visit3[x][y] >= 2:
                        result.append([cnt, visit[mx][my], visit3[x][y]])

    return result


def solution(n, m, land):
    visit = [[0]*M for _ in range(N)]
    cnt, dis = 1, 0
    island, result = [], []
    for i in range(n):
        for j in range(m):
            if land[i][j] == 1 and visit[i][j] ==0:
                island.append(bfs(i, j, cnt, visit))
                cnt += 1


    for i in range(cnt-1):
        result.extend(bfs2(island[i], i+1, n, m, visit))


    # 다리 연결 확인하기 
    # result.sort(key=lambda x:x[2])
    # graph = { i:[] for i in range(1, cnt)}

    # for r in result:
    #     i, j, d = r
    #     graph[i].append((j, d))
    #     dis = check(graph, cnt-1)
    #     if dis != -1:
    #         return dis


    return -1


N, M = map(int, input().split())
Land = [list(map(int, input().split())) for _ in range(N)]
print(solution(N, M, Land))