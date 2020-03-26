# import sys; input = sys.stdin.readline
# n, m = map(int, input().split())
# a = [ list(map(int, list(input().strip()))) for _ in range(n) ]
# visit=[[0]*m for _ in range(n)]; move = [[-1, 0], [1, 0], [0, -1], [0, 1]];queue = [[0, 0]]
# visit[0][0] = 1
# while len(queue)!=0:
#     x, y = queue.pop(0)
#     for i in range(4):
#         nx = x + move[i][0]
#         ny = y + move[i][1]
#
#         if 0 > nx or nx >= n or 0 > ny or ny >= m or a[nx][ny]==0 or visit[nx][ny] != 0: continue
#         visit[nx][ny] = visit[x][y] + 1
#         queue.append([nx, ny])
#
# print(visit[n-1][m-1])

''' 다음에 다시 해보자... '''

'''
방문하는 곳이 몇번째 방문인지 count ( 13번 참조 )
'''

import sys; input = sys.stdin.readline
n, m = map(int, input().split())
maze = [ list(map(int, input().strip())) for _ in range(n) ]
visit = [ [0]*m for _ in range(n) ]; move = [ [1, 0], [-1, 0], [0, 1], [0, -1] ]
queue = [[0, 0]]; visit[0][0] = 1
while queue:
    node = queue.pop(0)
    visit.append(node)

    for mm in move:
        new = [node[0] + mm[0], node[1] + mm[1]]
        if new[0] >= 0 and new[0] < n and new[1] >= 0 and new[1] < m:
            if maze[new[0]][new[1]]==1 and new not in visit and new not in queue:
                queue.append(new)
                visit[new[0]][new[1]] = visit[node[0]][node[1]] + 1
print(visit[n-1][m-1])

'''     BFS로 해야되는 문제    '''