import sys; input=sys.stdin.readline
def area(arr, h, n):
    cnt = 0
    visit = [[0] * n for _ in range(n)]

    for i in range(n):
        for j in range(n):
            if arr[i][j] > h and visit[i][j]==0:
                cnt += 1
                stack = [(i, j)]
                while stack:
                    x, y = stack.pop()
                    visit[x][y] = 1
                    for m1, m2 in (-1, 0), (0, -1), (1, 0), (0, 1):
                        mx = x + m1
                        my = y + m2
                        if 0<=mx<n and 0<=my<n and arr[mx][my] > h and visit[mx][my]==0:
                            stack.append((mx, my))
    return cnt

def solution(n, arr):
    cnt = 1
    seta = set()

    for a in arr:
        seta = seta | set(a)

    for s in seta:
        x = area(arr, s, n)
        if cnt < x:
            cnt = x
    return cnt

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
print(solution(n, arr))