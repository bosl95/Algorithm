import sys
from collections import deque

input =sys.stdin.readline

def solution(n, k, m, route):
    s = deque([1])
    chk = [0]*(N+M+1)
    chk[1] = 1

    while s:
        x = s.popleft()
        if x == n:
            return chk[x]

        for j in route[x]:
            if chk[j]:
                continue
            if j<=n:
                chk[j] = chk[x] + 1
            else:
                chk[j] = chk[x]
            s.append(j)

    return -1


N, K, M = map(int, input().split())
Route = [[] for _ in range(N+M+1)]
for i in range(1, M+1):
    tmp = list(map(int, input().split()))
    for j in range(K):
        Route[tmp[j]].append(N+i)
        Route[N+i].append(tmp[j])
print(solution(N, K, M, Route))