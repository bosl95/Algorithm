import sys;input=sys.stdin.readline
n = int(input())
arr = [list(map(int, input().split()[0])) for _ in range(n) ]
# dfs = []; visit = []; count=[]
#
# def DFS(a, b):
#     dfs.append((a, b))
#     depth = 0
#     while dfs:
#         a, b = dfs.pop()
#         if (a, b) not in visit:
#             visit.append((a, b))
#             depth+=1
#             if a-1>=0 and arr[a-1][b]==1 and (a-1, b) not in visit: dfs.append((a-1, b))
#             if a+1<n and arr[a+1][b]==1 and (a+1, b) not in visit: dfs.append((a+1, b))
#             if b-1>=0 and arr[a][b-1]==1 and (a, b-1) not in visit: dfs.append((a, b-1))
#             if b+1<n and arr[a][b+1]==1 and (a, b+1) not in visit: dfs.append((a, b+1))
#             # a, b를 [1, 0] [-1, 0] [0, 1] [0, -1] 로 나눠서 해도 되는 군.
#     return depth

# for i in range(n):
#     for j in range(n):
#         if arr[i][j]==1:
#             result = DFS(i, j)
#             if result != 0 : count.append(result)
#
# print(len(count)); count.sort()
# for c in count:
#     print(c)

'''
DFS 성공
BFS로 2차 시도!!!
'''
bfs = []; visit = []; count = []

def BFS(i, j):
    depth = 0
    bfs.append((i, j))  # start_node
    index_arr = [(1, 0), (-1, 0), (0, 1), (0, -1)]
    while bfs:
        a, b = bfs.pop(0)
        if (a, b) not in visit:
            visit.append((a, b))
            depth += 1
            for index in index_arr:
                x, y = index
                if a+x >= 0 and a+x < n and b+y>=0 and b+y < n and (a+x, b+y) not in visit and arr[a+x][b+y] == 1:
                    bfs.append((a+x, b+y))
    return depth

for i in range(n):
    for j in range(n):
        if arr[i][j]==1:
            result = BFS(i, j)
            if result != 0:  count.append(result)

print(len(count)); count.sort()
for c in count:
    print(c)
'''
BFS도 통과! 시간은 84ms로 동일하다.
'''