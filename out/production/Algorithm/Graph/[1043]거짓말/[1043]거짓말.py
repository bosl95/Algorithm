import sys
from collections import deque

input =sys.stdin.readline

def solution(n, m, A, know):
    s = deque(set(map(int, know)))
    chk = [1]*(n+m+1)

    while s:
        x = s.popleft()
        chk[x] = 0
        for j in A[x]:
            if chk[j]==0:
                continue
            s.append(j)
    print(sum(chk[n+1:]))

N, M = map(int, input().split())
know = input().split()
arr = [[] for _ in range(N+M+1)]
if len(know)<=1:
    for _ in range(M): input()
    print(M)
else:
    for i in range(1, M+1):
        tmp = list(map(int, input().split()))
        for j in range(1, tmp[0]+1):
            arr[tmp[j]].append(N+i)
            arr[N+i].append(tmp[j])
    solution(N, M, arr, know[1:])