import sys
from collections import deque
input =sys.stdin.readline

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]  # 하 상 우 좌

def bfs(start, num):    # 섬 찾기
    a, b = start
    island[a][b] = num
    stack = deque([(a, b)])
    result = set()
    while True:
        tmp = set()
        while stack:
            x, y = stack.popleft()
            for i in range(4):
                mx, my = x+dx[i], y+dy[i]
                if 0<=mx<n and 0<=my<m and island[mx][my]==0:
                    if land[mx][my] == 0:
                        result.add((x, y)) # 섬 경계선
                    else:
                        island[mx][my] = num
                        tmp.add((mx, my))
        if tmp:
            stack.extend(tmp)
        else:
            return result

def bfs2(lines, cnt):
    for i in range(4):
        stack = deque(lines.copy())
        dis = 0
        while True:
            tmp = []
            while stack:
                x, y = stack.popleft()
                mx, my = dx[i]+x, dy[i]+y
                if 0<=mx<n and 0<=my<m:
                    if island[mx][my] == 0:
                        tmp.append((mx, my))
                    elif island[mx][my] != cnt and dis >= 2:
                        h.add((dis, cnt, island[mx][my]))
                        tmp = []
                        break
            if tmp: stack.extend(tmp); dis += 1
            else: break

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(r_u, r_v):
    if rank[r_u] > rank[r_v]:
        parent[r_v] = r_u
    else:
        parent[r_u] = r_v
        if rank[r_v] == rank[r_u]:
            rank[r_v] += 1

n, m = map(int, input().split())
land = [list(map(int, input().split())) for _ in range(n)]
island = [[0]*m for _ in range(n)]
cnt, line = 1, []   # line : 경계선
parent, rank = dict(), dict()
for i in range(n):
    for j in range(m):
        if land[i][j] != 0 and island[i][j] ==0:
            line.append(bfs((i, j), cnt))
            parent[cnt] = cnt
            rank[cnt] = 0
            cnt += 1
h = set()
for i in range(1, cnt):
    bfs2(line[i-1], i)

value = 0
for hh in sorted(h):
    w, u, v = hh
    r_u, r_v = find(u), find(v)
    if r_u != r_v:
        union(r_u, r_v)
        value += w
        cnt-=1

print(value if cnt==2 else -1)
