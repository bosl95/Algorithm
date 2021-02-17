import heapq
import sys
input=sys.stdin.readline



def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(r_u, r_v):
    if rank[r_v] > rank[r_u]:
        parent[r_u] = r_v
    else:
        parent[r_v] = r_u
        if rank[r_v] == rank[r_u]:
            rank[r_v] += 1

def solution(n, m, h, a):
    for i in range(n):
        parent[i] = i
        rank[i] = 0
    x, value = 0, 0
    while h:
        w, u, v = heapq.heappop(h)
        ru, rv = find(u), find(v)
        if ru != rv:
            union(ru, rv)
            x, value = x+1, value+w
            if x == n-1:
                return a-value


while True:
    n, m = map(int, input().split())
    if (n,m) == (0,0):
        break
    parent = dict()
    rank = dict()
    h = []
    all = 0
    for _ in range(m):
        x, y, z = map(int, input().split())
        all += z
        heapq.heappush(h, [z, x, y])
    print(solution(n, m, h, all))
