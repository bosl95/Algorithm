import sys
from collections import deque

input =sys.stdin.readline

N = int(input())
Nodes, connect = [], []
Max = sys.maxsize

for i in range(N):
    L, R = map(int, input().split())
    Nodes.append([L, R])
    connect.append([Max]*N)
    connect[i][i] = 0

# 중복된 범위가 있는 노드끼리 선분을 이어준다.
for i in range(N):
    for j in range(N):
        if i==j or Nodes[i][1] < Nodes[j][0] or Nodes[j][1] < Nodes[i][0]: continue
        connect[j][i] = 1
        connect[i][j] = 1

# 플로이드 알고리즘으로 최단 경로를 구한다.
for k in range(N):
    for i in range(N):
        for j in range(N):
            if connect[i][j] > connect[i][k] + connect[k][j]:
                connect[i][j] = connect[i][k] + connect[k][j]

Q = int(input())
for _ in range(Q):
    A, B = map(int, input().split())
    print(-1 if connect[A-1][B-1]==Max else connect[A-1][B-1])


# python 통과
import sys
from collections import deque

input =sys.stdin.readline

N = int(input())
Nodes = [0] + [list(map(int, input().split())) for _ in range(N)]

con = [[] for _ in range(N+1)]
for i in range(1, N+1):
    for j in range(1, N+1):
        if Nodes[i][1] >= Nodes[j][0] or Nodes[j][1] >= Nodes[i][0]:
            con[i].append(j)


def solution(l, r):
    stack = deque([l])
    chk = [0] * (N+1)
    chk[l] = 1
    while stack:
        x = stack.popleft()
        for v in con[x]:
            if chk[v] == 0:
                chk[v] = chk[x]+1
                stack.append(v)
                if v==r:
                    return chk[x]
    return -1


Q = int(input())
for _ in range(Q):
    A, B = map(int, input().split())
    print(solution(A, B))
