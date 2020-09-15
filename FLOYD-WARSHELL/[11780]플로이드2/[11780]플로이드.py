import sys
input =sys.stdin.readline

inf = sys.maxsize
N = int(input())
M = int(input())

city = [[inf]*N for _ in range(N)]
route = [[[] for _ in range(M)] for _ in range(N)]


for _ in range(M):
    a, b, c = map(int, input().split())
    if city[a-1][b-1] > c:
        city[a-1][b-1] = c
        route[a-1][b-1] = b-1

for i in range(N):
    city[i][i] = 0


for k in range(N):
    for i in range(N):
        for j in range(N):
            if i!=j and city[i][j] > city[i][k]+city[k][j]:
                city[i][j] = city[i][k]+city[k][j]
                route[i][j] = route[i][k]

for i in range(N):
    for j in range(N):
        print('0' if city[i][j]==inf else city[i][j], end=' ')
    print()

for i in range(N):
    for j in range(N):
        if city[i][j] == inf or city[i][j]==0:
            print(0)
            continue
        path = []
        st = i
        while st!=j:
            path.append(str(st+1))
            st = route[st][j]
        path.append(str(j+1))
        print(len(path), ' '.join(path))
