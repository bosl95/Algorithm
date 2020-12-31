import sys; input=sys.stdin.readline
m, n, h = map(int, input().split());
Arr= [[ [0]*m for _ in range(n) ] for _ in range(h) ]
queue = []
for hh in range(h):
    for i in range(n):
        tmp = list(map(int, input().split()))
        for j in range(m):
            Arr[hh][i][j] = tmp[j]
            if tmp[j] == 1: queue.append((hh, i, j))
queue = [queue]; count = 0
while queue:
    Q = queue.pop(0)
    tmp = []; count += 1
    for x, y, z in Q:
        for a, b, c in (0, 1, 0), (0, -1, 0), (0, 0, 1), (0, 0, -1), (-1, 0, 0), (1, 0, 0):
            xx = x+a; yy= y+b; zz = z+c
            if 0<=xx<h and 0<=yy<n and 0<=zz<m and Arr[xx][yy][zz]==0:
                tmp.append((xx, yy, zz))
                Arr[xx][yy][zz] = 1
    if tmp: queue.append(tmp)
for a in Arr:
    for aa in a:
        if 0 in aa:
            print(-1)
            exit()
print(count-1)