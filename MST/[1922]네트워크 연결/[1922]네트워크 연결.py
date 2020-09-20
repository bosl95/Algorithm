import heapq
import sys
input = sys.stdin.readline

parent = dict()
rank = dict()

def union(ru, rv):
    if rank[ru] > rank[rv]:
        parent[rv] = ru
    else:
        parent[ru] = rv
        if rank[ru] == rank[rv]:
            rank[rv] += 1

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def solution(h, N, M):
    for i in range(1,N+1):
        rank[i], parent[i]= 0, i
    i, res = 0, 0

    while h:
        w, u, v = heapq.heappop(h)
        ru, rv = find(u), find(v)
        if ru != rv:
            res, i = res+w, i+1
            union(ru, rv)
            if i==N-1:
                return res

N = int(input())
M = int(input())
h = []
for _ in range(M):
    a, b, c = map(int, input().split())
    heapq.heappush(h, [c, a, b])

print(solution(h, N, M))