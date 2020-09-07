import sys
input = sys.stdin.readline
N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
color = [0, 0]

def bfs(x, y, n, c):
# 색깔이 다른 경우 4분할하여 재귀
    if n==1:
        color[c] += 1
        return
    else:
        for i in range(x, x+n):
            for j in range(y, y+n):
                if arr[i][j] != c:
                    bfs(x, y, n//2, arr[x][y])
                    bfs(x + n // 2, y, n // 2, arr[x + n // 2][y])
                    bfs(x , y + n // 2, n // 2, arr[x][y + n // 2])
                    bfs(x + n // 2, y + n // 2, n // 2, arr[x + n // 2][y + n // 2])
                    return
        color[c] += 1


bfs(0, 0, N, arr[0][0])
print(color[0])
print(color[1])