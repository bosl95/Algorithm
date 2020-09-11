import sys, math
import heapq
input=sys.stdin.readline

parents = dict()
rank = dict()


def calc(u, v):
    x1, y1 = u
    x2, y2 = v
    return round(math.sqrt((x2-x1)**2 + (y2-y1)**2), 2)

def find(node): # 루트 노드 찾기
    if parents[node] != node:
        parents[node] = find(parents[node])

    return parents[node]

def union(root1, root2):    #
    if rank[root1] > rank[root2]:
        parents[root2] = root1
    else:
        parents[root1] = root2

        if rank[root1] == rank[root2]:
            rank[root2] += 1

def solution(a, n):
    heap, nodes, result = [], dict(), 0
    for i in range(n):
        parents[i] = i  # 초기화
        rank[i] = 0
        for j in range(i+1, n):
            heapq.heappush(heap, [calc(a[i], a[j]), i, j])

    while heap:
        w, u, v = heapq.heappop(heap)
        root1, root2 = find(u), find(v)
        if root1 != root2:
            union(root1, root2)
            result += w

    return result


A, n= [], int(input())
for _ in range(n):
    A.append(list(map(float, input().split())))
print(solution(A, n))