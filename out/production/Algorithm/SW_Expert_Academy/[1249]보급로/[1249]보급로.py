from collections import deque

T = int(input())


def solution(n, M):
    stack = deque([(0, 0)])
    visit = [[-1] * n for _ in range(n)]
    visit[0][0] = 0
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]

    while stack:
        x, y = stack.popleft()
        for i in range(4):
            mx = x + dx[i]
            my = y + dy[i]
            if 0 <= mx < n and 0 <= my < n:
                if visit[mx][my] == -1 or visit[mx][my] > visit[x][y] + M[mx][my]:
                    visit[mx][my] = visit[x][y] + M[mx][my]
                    stack.append((mx, my))
    return visit[n - 1][n - 1]


for test_case in range(1, T + 1):
    n = int(input())
    Map = [list(map(int, list(input()))) for _ in range(n)]
    print("#{} {}".format(test_case, solution(n, Map)))
