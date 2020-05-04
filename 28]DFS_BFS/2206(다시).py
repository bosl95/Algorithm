import sys; input=sys.stdin.readline
n, m = map(int, input().split())
arr = [ list(map(int, list(input().strip()))) for _ in range(n) ]
visit = [ [ [0]*m for _ in range(n) ] for _ in range(2) ]   # key point

def bfs():
    queue = [(0, 0, 0)]
    visit[0][0][0] = 1
    while queue:
        x, y, z = queue.pop(0)
        if y == n-1 and z == m-1: return visit[x][y][z]
        for i, j in (-1, 0), (0, -1), (1, 0), (0, 1):
            ny, nz = y + i, z + j
            if 0<=ny<n and 0<=nz<m :
                if not visit[x][ny][nz]:
                    if not arr[ny][nz]: # arr = 0
                        visit[x][ny][nz] = visit[x][y][z] + 1
                        queue.append((x, ny, nz))
                    elif arr[ny][nz] and not x: # arr = 1 & visit[0]일때 라면
                        visit[1][ny][nz] = visit[x][y][z] + 1
                        queue.append((1, ny, nz))
    return -1
print(bfs())