dx = [-1, -1, -1, 0, 0, 1, 1, 1]
dy = [1, 0, -1, 1, -1, 1, 0, -1]

def count(i, j, n, arr):
    res = 0
    for k in range(8):
        mx = i + dx[k]
        my = j + dy[k]
        if 0<=mx<n and 0<=my<n and arr[mx][my] =="*":
            res += 1
    return res

def dfs(i, j, visit):
    stack = [[i, j]]
    while stack:
        x, y = stack.pop()
        value = 0
        tmp = []
        visit[x][y] = 1
        for k in range(8):
            mx = x + dx[k]
            my = y + dy[k]
            if 0<=mx<n and 0<=my<n and visit[mx][my]==0:
                tmp.append([mx, my])
                if arr[mx][my] == '*':
                    value += 1
        arr[x][y] = value
        if value == 0:
            stack.extend(tmp)

def solution(n, arr):
    visit = [[0]*n for _ in range(n)]
    result = 0

    for i in range(n):
        for j in range(n):
            if arr[i][j] ==".":
                num = count(i, j, n, arr)
                if num == 0:
                    dfs(i, j, visit)
                    result += 1

    for i in range(n):
        for j in range(n):
            if arr[i][j] == ".":
                result+=1

    return result

T = int(input())

for test_case in range(1, T + 1):
    n = int(input())
    arr = [list(input()) for _ in range(n)]
    print("#{} {}".format(test_case, solution(n, arr)))