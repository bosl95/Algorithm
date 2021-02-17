import sys
from collections import defaultdict

input = sys.stdin.readline

def solution(n, m, arr):
    s, cnt, chk = [1], 1, [0]*(n+1)
    chk[1] = 1
    while True:
        tmp = []
        print(id(tmp), id(s))
        for x in s:
            for j in arr[x]:
                if chk[j]:
                    continue
                tmp.append(j)
                chk[j] = 1
        if tmp:
            cnt += 1
            s = tmp
        else:
            break

n, m = map(int, input().split())
cabin = [[] for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    cabin[a].append(b)
    cabin[b].append(a)
solution(n, m, cabin)