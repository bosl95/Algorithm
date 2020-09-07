import sys
from collections import deque

input = sys.stdin.readline
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

# https://debuglog.tistory.com/84

def bfs(i, j, cnt, visit):
    stack = [(i, j)]
    visit[i][j] = cnt
    result = []

    while stack:
        x, y = stack.pop()
        for k in range(4): # 빈 땅을 발견하는 지점이 하나라도 있으면 추가해야함.
            mx = x + dx[k]
            my = y + dy[k]
            if 0<= mx <N and 0<=my<M and visit[mx][my] != cnt:
                if Land[mx][my] == 0 and visit[x][y]==cnt :   # 땅 발견
                    if (x, y) not in result:
                        result.append((x, y))
                else:
                    visit[mx][my] = cnt
                    stack.append((mx, my))

    return result

def bfs2(stack, cnt, visit):
    tmp, result = [[], [], [], []], []
    visit2 = [[0]*M for _ in range(N)]

    while stack:
        x, y = stack.pop()
        for i in range(4):
            mx, my = x+dx[i], y+dy[i]
            if 0<=mx<N and 0<=my<M and Land[mx][my] == 0:
                visit2[mx][my] = visit2[x][y] + 1
                tmp[i].append((x, y))


    for i in range(4):
        stack = deque(tmp[i].copy())
        while stack:
            x, y = stack.pop()
            mx, my = x + dx[i], y + dy[i]
            if 0 <= mx < N and 0 <= my < M and visit[mx][my] != cnt:
                if visit[mx][my] == 0:
                    stack.append((mx,my))
                    visit2[mx][my] = visit2[x][y] + 1
                else:
                    if visit2[x][y] > 1:
                        result.append([cnt, visit[mx][my] ,visit2[x][y]])




    return result

parent = dict()
rank = dict()

def make_set(cnt):
    for i in range(1, cnt):
        parent[i] = i
        rank[i] = 0

# 해당 정점의 최상위 정점을 찾는다.
def find(node):
    if parent[node] != node:
        parent[node] = find(parent[node])
    return parent[node]

def union(v, u):
    root1 = find(v)
    root2 = find(u)

    # 짧은 트리의 루트가 긴 트리의 루트를 가리키게 만드는 것이 좋다.
    if rank[root1] > rank[root2]:
        parent[root2] = root1
    else:
        parent[root1] = root2
        if rank[root1] == rank[root2]:
            rank[root2] += 1

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
        for r in bfs2(island[i], i+1, visit):
            if r not in result and [r[1], r[0], r[2]] not in result:
                result.append(r)


    result.sort(key=lambda x:x[2])

    ans = 0
    make_set(cnt) # 초기화

    i=0
    while i < cnt-1:
        if len(result)==0:
           return -1

        u, v, d = result.pop(0)
        p1 = find(u)
        p2 = find(v)

        if p1==p2:
            continue

        parent[p1] = parent[p2]
        i += 1
        ans += d


    return ans




N, M = map(int, input().split())
Land = [list(map(int, input().split())) for _ in range(N)]
print(solution(N, M, Land))