import sys; input=sys.stdin.readline
m, n = map(int, input().split())
arr = [[0]*m for _ in range(n)]; queue = []
for i in range(n):
    tmp = list(map(int, input().split()))
    for j in range(m):
        arr[i][j] = tmp[j]
        if tmp[j] == 1: queue.append((i, j))
queue = [queue]; count = 0
while queue:
        Q = queue.pop(0)
        tmp = []
        count += 1
        for x, y in Q:
            for i, j in (-1, 0), (1, 0), (0, -1), (0, 1):
                xx = x+i; yy = y+j
                if 0<=xx<n and 0<=yy<m and arr[xx][yy]==0:
                    tmp.append((xx, yy))
                    arr[xx][yy] = 1
        if tmp: queue.append(tmp)
for a in arr:
    if 0 in a:
        print(-1)
        exit()
print(count-1)