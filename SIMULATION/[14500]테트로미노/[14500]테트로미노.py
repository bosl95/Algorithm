import sys
input=sys.stdin.readline

def sumcheck(x, y, cnt):
    global ans
    if cnt == 1:
        t = sum([ Board[x][y+i] for i in range(4)])
    elif cnt == 2:
        t = sum([Board[x+i][y] for i in range(4)])
    elif cnt == 3:
        t = Board[x][y] + Board[x+1][y] + Board[x][y+1] + Board[x+1][y+1]
    elif cnt == 4:
        a, b, c, d, e, f = Board[x][y], Board[x][y+1], Board[x][y+2], Board[x+1][y], Board[x+1][y+1], Board[x+1][y+2]
        t1 = a+b+c+f
        t2 = a+b+c+d
        t3 = a+d+e+f
        t4 = c+d+e+f
        t5 = b+d+e+f
        t6 = a+b+c+e
        t7 = a+b+e+f
        t8 = b+c+d+e
        t = max(t1, t2, t3, t4, t5, t6, t7, t8)
    elif cnt == 5:
        a, b, c, d, e, f = Board[x][y], Board[x][y+1], Board[x+1][y], Board[x+1][y+1], Board[x+2][y], Board[x+2][y+1]
        t1 = a+b+d+f
        t2 = a+c+e+f
        t3 = a+c+d+f
        t4 = b+c+d+e
        t5 = b+c+d+f
        t6 = a+c+d+e
        t7 = a+b+c+e
        t8 = b+d+e+f
        t = max(t1, t2, t3, t4, t5, t6, t7, t8)
    if ans < t: ans = t

def solution(n, m):
    for i in range(n):
        for j in range(m):
            if j <= m-4: sumcheck(i, j, 1)
            if i <= n-4: sumcheck(i, j, 2)
            if i <= n-2 and j <= m-2: sumcheck(i, j, 3)
            if i <= n-2 and j <= m-3: sumcheck(i, j, 4)
            if i <= n-3 and j <= m-2: sumcheck(i, j, 5)
    print(ans)

N, M = map(int, input().split())
Board = [list(map(int, input().split())) for _ in range(N)]
ans = 0
solution(N, M)