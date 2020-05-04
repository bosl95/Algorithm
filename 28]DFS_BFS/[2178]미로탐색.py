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

# import sys; input = sys.stdin.readline
n, m = map(int, input().split())
maze = [ list(map(int, input())) for _ in range(n) ]
visit = [ [0]*m for _ in range(n) ]
queue = [[0, 0]]; visit[0][0] = 1
while queue:
    x, y = queue.pop(0)
    visit.append([x, y])

    for mx, my in [1, 0], [-1, 0], [0, 1], [0, -1]:
        xx, yy = x + mx, y + my
        if 0 <=  xx < n and 0 <= yy < m and maze[xx][yy]==1 and visit[xx][yy] == 0:
            queue.append([xx, yy])
            visit[xx][yy] = visit[x][y] + 1
print(visit[n-1][m-1])

'''     BFS로 해야되는 문제    '''
'''
35줄에 visit[xx][yy]===0 이랑
xx, yy not in visit  이랑
시간차가 큼
'''