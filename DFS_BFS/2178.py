import sys; input = sys.stdin.readline
n, m = map(int, input().split())
a = [ list(map(int, list(input().strip()))) for _ in range(n) ]
visit=[[0]*m for _ in range(n)]; move = [[-1, 0], [1, 0], [0, -1], [0, 1]];queue = [[0, 0]]
visit[0][0] = 1
while len(queue)!=0:
    x, y = queue.pop(0)
    for i in range(4):
        nx = x + move[i][0]
        ny = y + move[i][1]

        if 0 > nx or nx >= n or 0 > ny or ny >= m or a[nx][ny]==0 or visit[nx][ny] != 0: continue
        visit[nx][ny] = visit[x][y] + 1
        queue.append([nx, ny])

print(visit[n-1][m-1])

''' 다음에 다시 해보자... '''