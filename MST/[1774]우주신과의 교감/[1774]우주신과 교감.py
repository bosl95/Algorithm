import math
import sys

input = sys.stdin.readline
import heapq


def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(r_u, r_v):
    if r_u != r_v:
        parent[r_v] = r_u

def calc(x1, y1, x2, y2):
    return math.sqrt((x1-x2)**2 + (y1-y2)**2)


def solution(n, m, ns, cnt):
    h = []

    for i in range(n-1):
        for j in range(i+1, n):
            w = calc(ns[i][0], ns[i][1], ns[j][0], ns[j][1])
            heapq.heappush(h, (w, i, j))

    ans = 0

    while h:
        w, u, v  = heapq.heappop(h)
        u, v = find(u), find(v)
        if u != v:
            union(u, v)
            ans += w
            cnt += 1
        if cnt == n-1:
            break
    return ans


N, M = map(int, input().split())
parent = {i:i for i in range(N)}

cnt = 0
Ns = [list(map(int, input().split())) for _ in range(N)]
for _ in range(M):
    u, v = map(int, input().split())
    u, v = find(u-1), find(v-1)
    if u != v:
        union(u, v)
        cnt += 1

print("%0.2f"%(solution(N, M, Ns, cnt)))