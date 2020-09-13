import sys
from collections import defaultdict

input=sys.stdin.readline


def solution(n, m, edges):
    chk = [0] * (n+1)
    s, cnt =  [], 0

    for i in range(1, n+1):
        if chk[i] == 1:
            continue
        s.append(i)     # 새로운 정점 발견
        chk[i] = 1
        cnt += 1
        while s:        # 연결된 정점 모두 찾기
            x = s.pop()
            for j in edges[x]:
                if chk[j] == 1:
                    continue
                s.append(j)
                chk[j] = 1
    return cnt


N, M = map(int, input().split())
edges = defaultdict(list)
for _ in range(M):
    a, b = map(int, input().split())
    edges[a].append(b)
    edges[b].append(a)

print(solution(N,M, edges))