import sys
from collections import defaultdict

input=sys.stdin.readline

def solution(n, m, st):
    chk = [0] * (n+1)

    for i in st[1]:
        chk[i] = 1
        for j in st[i]:
            if chk[j] == 1:
                continue
            chk[j] = 1

    chk[1] = 0
    return sum(chk)

N = int(input())
M = int(input())
stu = defaultdict(list)
for _ in range(M):
    a, b = map(int, input().split())
    stu[a].append(b)
    stu[b].append(a)
print(solution(N, M, stu))
