import sys; input = sys.stdin.readline
def dfs(m, arr, visit, color):
    stack = [m]
    while stack:
        i, j = stack.pop()
        for x, y in (1, 0), (0, 1), (-1, 0), (0, -1):
            mx = i + x
            my = j + y
            if 0<= mx<n and 0<=my<n and visit[mx][my]==0 and arr[mx][my] in color:
                stack.append((mx, my))
                visit[mx][my] = 1
    return 1

def check(flag, arr, n):
    visit = [[0] * n for _ in range(n)]
    cnt = 0
    if flag:
        for i in range(n):
            for j in range(n):
                if visit[i][j] ==0:
                    cnt += dfs((i, j), arr, visit, [arr[i][j]])
        return cnt
    else:
        for i in range(n):
            for j in range(n):
                if visit[i][j] == 0:
                    color = ['B'] if arr[i][j]=='B' else ['R', 'G']
                    cnt += dfs((i, j), arr, visit, color)
        return cnt


def solution(n, arr):
    return [ check(True, arr, n), check(False, arr, n) ]

n = int(input())
arr = [list(input().strip()) for _ in range(n)]
print(*solution(n, arr))