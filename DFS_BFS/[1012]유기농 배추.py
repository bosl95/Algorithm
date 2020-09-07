# import sys; input=sys.stdin.readline
# N = int(input()); Arr = []; In = [] # In : (m, n, k)를 저장
#
# for _ in range(N):
#     In.append(list(map(int, input().split())))
#     m, n, k = In[-1]
#     arr = [ [0]*n for _ in range(m) ]
#     for _ in range(k):
#         i, j = map(int, input().split())
#         arr[i][j] = 1
#     Arr.append(arr)
#
# def BFS(arr, m, n):
#     visit = [];bfs = []; count = 0
#     for i in range(m):
#         for j in range(n):
#             if visit:
#                 if arr[i][j] == 1 and (i, j) not in visit:
#                     bfs.append((i, j))
#                     visit.append((i, j))
#                     count += 1
#             else:
#                 if arr[i][j] == 1:  # 처음 시작점
#                     bfs.append((i, j))
#                     visit.append((i, j))
#                     count += 1
#
#             A = [1, -1, 0, 0]; B=[0, 0, 1, -1]
#             while bfs:
#                 node_i, node_j = bfs.pop(0)
#                 if arr[node_i][node_j] == 1 and (node_i, node_j) not in visit : visit.append((node_i, node_j))
#                 for a, b in zip(A, B):
#                     if node_i+a>=0 and node_i+a<m and node_j+b>=0 and node_j+b<n and (node_i+a, node_j+b) not in visit and arr[node_i+a][node_j+b]==1:
#                         bfs.append((node_i+a, node_j+b))
#
#     return count
#
# for i in range(N):
#     print(BFS(Arr[i], In[i][0], In[i][1]))

'''     시간 초과...        '''

# import sys; input=sys.stdin.readline
# N = int(input())
#
# def BFS(arr, m, n):
#     count = 0; visit = []
#
#     for i in range(m):
#         for j in range(n):
#             if arr[i][j]==1 and (i, j) not in visit:
#                 bfs = [(i, j)]
#
#                 count += 1
#                 while bfs:
#                     x, y = bfs.pop(0)
#                     if (x, y) not in visit:
#                         visit.append((x, y))
#                         if x - 1 >= 0 and arr[x - 1][y] == 1 and (x - 1, y) not in visit: bfs.append((x - 1, y))
#                         if x + 1 < m and arr[x + 1][y] == 1 and (x + 1, y) not in visit: bfs.append((x + 1, y))
#                         if y - 1 >= 0 and arr[x][y - 1] == 1 and (x - 1, y) not in visit: bfs.append((x, y - 1))
#                         if y + 1 < n and arr[x][y + 1] == 1 and (x, y + 1) not in visit: bfs.append((x, y + 1))
#     return count
#
# for i in range(N):
#     m, n, k = map(int, input().split())
#     arr = [[0]*n for _ in range(m)]
#     for _ in range(k):
#         a, b = map(int, input().split())
#         arr[a][b] = 1
#     print(BFS(arr, m, n))

'''     새로운 마음으로 재시도        '''

# import sys; input=sys.stdin.readline;sys.setrecursionlimit(1000000)
# visit = []; num = 0; check = [[-1, 0], [1, 0], [0, -1], [0, 1]]
# N = int(input());
#
# def BFS(node):
#     tmp = [node]
#     while tmp:
#         tmp_node = tmp.pop(0)
#         visit.append(tmp_node)
#         for c in check:
#             new_node = [tmp_node[0]+c[0], tmp_node[1]+c[1]]
#             if new_node not in visit and new_node not in tmp and new_node in arr:
#                 tmp.append(new_node)
#
# for _ in range(N):
#     visit.clear()
#     n, m, k = map(int, input().split()); num = 0
#     arr = [ list(map(int, input().split())) for _ in range(k) ]
#     for a in arr:
#         if a not in visit:
#             BFS(a); num += 1
#     print(num)

''' 성공 근데 시간이 다른 코드들에 비해 오래 걸리는 편. '''
import sys; input=sys.stdin.readline;sys.setrecursionlimit(1000000)
di = [0, 1, 0, -1]
dj = [-1, 0, 1, 0]

def dfs(i, j):
    stack = [(i, j)]

    while(len(stack)):
        land[j][i] = 0
        for a in range(4):
            if land[j+dj[a]][i+di[a]]:
                stack.append((i, j))
                i += di[a]
                j += dj[a]
                break
        else:
            i, j = stack.pop()

N=int(input())
for _ in range(N):
    cnt = 0
    m, n, k = map(int, input().split()); num = 0
    land = [ [0] * (m+2) for i in range(n+2) ]

    for k in range(k):
        i, j = map(int, input().split())
        land[j+1][i+1] = 1

    for j in range(n):
        j += 1
        for i in range(m):
            i += 1
            if land[j][i]:
                cnt += 1
                dfs(i, j)
    print(cnt)

''' 숏코드'''