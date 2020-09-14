import sys
input=sys.stdin.readline

inf = sys.maxsize
n = int(input())
m = int(input())
route = [[inf]*n for _ in range(n)]

for _ in range(m):
    a, b, c = map(int, input().split())
    if route[a-1][b-1] > c:
        route[a-1][b-1] = c

for i in range(n):
    route[i][i] = 0

for k in range(n):
    for i in range(n):
        for j in range(n):
            if i!=j and route[i][j] > route[i][k]+route[k][j]:
                route[i][j] = route[i][k]+route[k][j]

for i in range(n):
    for j in range(n):
        if route[i][j] == inf:
            print(0, end=" ")
        else:
            print(route[i][j], end=" ")
    print()