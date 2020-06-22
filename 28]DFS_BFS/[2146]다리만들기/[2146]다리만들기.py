import sys
from collections import deque

input = sys.stdin.readline

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]


def bfs(start, cnt):
    visit[start[0]][start[1]] = cnt
    q = deque([start])
    tmp = deque()

    while q:
        x, y = q.popleft()
        for i in range(4):
            mx = x + dx[i]
            my = y + dy[i]
            if 0 <= mx < n and 0 <= my < n:
                if visit[mx][my] == 0:
                    if arr[mx][my] == 1:
                        visit[mx][my] = cnt
                        q.append([mx, my])
                    elif arr[mx][my] == 0 and [x, y] not in tmp:
                        tmp.append([x, y])
    return tmp


def bfs2(stack, cnt):
    visit2 = [[0] * n for _ in range(n)]

    while stack:
        x, y = stack.popleft()
        for i in range(4):
            mx = x + dx[i]
            my = y + dy[i]
            if 0 <= mx < n and 0 <= my < n:
                if arr[mx][my] == 1 and visit[mx][my] != cnt:
                    return visit2[x][y]
                if arr[mx][my] == 0 and visit2[mx][my] == 0:
                    visit2[mx][my] = visit2[x][y] + 1
                    stack.append([mx, my])


def solution(m, world):
    i_cnt = 1
    start = []

    for i in range(m):
        for j in range(m):
            if world[i][j] == 1 and visit[i][j] == 0:
                start.append(bfs((i, j), i_cnt))
                i_cnt += 1


    res = bfs2(start[0], 1)
    for i in range(1, i_cnt - 1):
       res = min(res, bfs2(start[i], i + 1))

    return res

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
visit = [[0] * n for _ in range(n)]
print(solution(n, arr))

'''
섬을 모두 찾아준다. (몇개 인가)
섬을 찾으면서 바로 거리를 잰다.
섬의 경계를 넘어가는 부분부터 visit의 카운트를 해주면서 거리를구한다.
거리를 계속 구해나가다가 다른 섬의 경계를 발견하면 res에 삽입
(이때 bfs 탐색을 이용하기 때문에 가장 짧은 거리의 섬을 찾을 수 있따.)
섬마다 각 거리에 있는 애들을 방문해준다.
'''
