'''
깊이 우선 탐색 (DFS, Depth-First Search)
: 한 방햐으로 갈 수 있을 때까지 계속 가다가 더 이상 갈 수 없게 되면
다시 가장 가까운 갈림길로 돌아와서 이곳으로부터 다른 방향으로 다시 탐색 진행
(어떤 노드를 방문했는지 여부를 반드시 검사해야한다)

너비 우선 탐색 (BFS, Breadth-First Search)
: 시작 노드부터 인접한 노드를 먼저 다 탐색함
'''

import sys;input=sys.stdin.readline
N, M, V = map(int, input().strip().split())
arr = [[0]*(N+1) for _ in range(N+1)]
DFS_ch=[];BFS_ch=[V];

def DFS(v):
    DFS_ch.append(v)
    for i in range(1, N+1):
        if arr[v][i]==1 and i not in DFS_ch:
            DFS(i)
    return DFS_ch

def BFS(v):
    j = 1
    while len(BFS_ch) != N:
        for i in range(1, N+1):
            if arr[v][i] ==1 and i not in BFS_ch:
                BFS_ch.append(i)
        if j<M:
            v = BFS_ch[j];j+=1
        else:
            break
    return BFS_ch

for _ in range(M):
    i, j = map(int, input().strip().split())
    arr[i][j] = arr[j][i] = 1
print(*DFS(V))
print(*BFS(V))