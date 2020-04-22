import sys;
input = sys.stdin.readline
N = int(input())
arr= [ list(map(int, list(input().strip()))) for _ in range(N) ]

def bfs(x, y, n, c):
    if n==1:
        print(c,end="")
        return
    else:
        for i in range(x, x+n):
            for j in range(y, y+n):
                if arr[i][j] != c:
                    print("(",end="")
                    bfs(x, y, n//2, arr[x][y])
                    bfs(x , y + n // 2, n // 2, arr[x][y + n // 2])
                    bfs(x + n // 2, y, n // 2, arr[x + n // 2][y])
                    bfs(x + n // 2, y + n // 2, n // 2, arr[x + n // 2][y + n // 2])
                    print(")",end="")
                    return
        print(c, end="")
bfs(0, 0, N, arr[0][0])