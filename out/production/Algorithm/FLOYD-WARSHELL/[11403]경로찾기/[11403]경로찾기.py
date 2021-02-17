import sys
from collections import deque

input=sys.stdin.readline


def solution(n, edge):
    reach = [[0]*n for _ in range(n)]

    for i in range(n):
        stack = deque([i])
        visit = [0]*n
        while stack:
            cur = stack.popleft()
            for j in range(n):
                if visit[j]==0 and edge[cur][j]:
                    stack.append(j)
                    reach[i][j] = 1
                    visit[j] = 1

    for r in reach:
        print(*r)

n = int(input())
edges = [list(map(int, input().split())) for i in range(n)]
solution(n, edges)