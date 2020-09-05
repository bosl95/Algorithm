import sys
from collections import deque

input = sys.stdin.readline
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def dfs(x, y):
    flag = True
    visit = [[0]*n for _ in range(n)]
    visit[x][y] = 1
    fish, time = [], 0
    stack = deque([(x, y)])
    while flag:
        tmp = []
        while stack:
            x, y = stack.popleft()
            for i in range(4):
                mx = x+dx[i]
                my = y+dy[i]
                if 0<=mx<n and 0<=my<n and visit[mx][my]==0 and space[mx][my] <= size:
                    visit[mx][my] = 1
                    tmp.append((mx, my))
                    if 0<space[mx][my] < size:  fish.append((mx, my))

        time += 1

        if fish:
            fish.sort(key=lambda x:(x[0], x[1]))
            # print(fish)
            # input()
            return [fish[0][0], fish[0][1], time]
        elif tmp:
            stack = deque(tmp.copy())
        else:
            return None

size, cnt, time = 2, 0, 0
n = int(input())
space = []

for i in range(n):
    line = list(map(int, input().split()))
    for j in range(n):
        if line[j] == 9:
            a, b = i, j
    space.append(line.copy())

while True:
    loc = dfs(a, b)
    if loc is None:
        print(time)
        break
    else:
        time += loc[2]
        space[a][b], space[loc[0]][loc[1]] = 0, 9
        a, b = loc[0], loc[1]
        space[a][b] = 0
        cnt += 1
        if cnt == size:
            size, cnt = size+1, 0