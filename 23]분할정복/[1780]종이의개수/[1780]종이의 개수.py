import sys; input=sys.stdin.readline
N = int(input()); num = [0, 0, 0]
arr = [list(map(int, input().split())) for _ in range(N)]

def bfs(x, y, n, c):
    if n==1:
        num[c] +=1
        return
    for i in range(x, x+n):
        for j in range(y, y+n):
            if arr[i][j]!=c:
                bfs(x, y, n//3, arr[x][y])
                bfs(x+n//3, y, n//3, arr[x+n//3][y])
                bfs(x+((n//3)*2), y, n//3, arr[x+((n//3)*2)][y])
                bfs(x, y+n//3, n//3, arr[x][y+n//3])
                bfs(x+n//3, y+n//3, n//3, arr[x+n//3][y+n//3])
                bfs(x + ((n // 3) * 2), y+n//3, n // 3, arr[x + ((n // 3) * 2)][y+n//3])
                bfs(x, y+((n//3)*2), n//3, arr[x][y+((n//3)*2)])
                bfs(x+n//3, y + ((n // 3) * 2), n // 3, arr[x+n//3][y+ ((n // 3) * 2)])
                bfs(x+((n//3)*2), y + ((n // 3) * 2), n // 3, arr[x+((n//3)*2)][y+((n // 3) * 2)])
                return
    num[c] += 1
bfs(0, 0, N, arr[0][0])
print(num[-1])
print(num[0])
print(num[1])