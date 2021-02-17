import sys
input = sys.stdin.readline

rank = dict()
parent = dict()

def union(r1, r2):
    if rank[r1] > rank[r2]:
        parent[r2]=r1
    else:
        parent[r1] = r2
        if rank[r1] == rank[r2]:
            rank[r2] += 1

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def solution(w_list):
    w_list.sort(key=lambda x:x[2])
    result = 0

    for w in w_list:
        n1, n2, v = w
        r1, r2 = find(n1), find(n2)
        if r1 != r2:
            union(r1, r2)
            result += v

    return result

V, E = map(int, input().split())
for i in range(V):
    parent[i] = i
    rank[i] = 0
List = []
for _ in range(E):
    u, v, w = map(int, input().split())
    List.append([u-1, v-1, w])
print(solution(List))
