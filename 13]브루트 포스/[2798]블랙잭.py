from itertools import combinations
N, M = map(int, input().split())
arr = list(map(int, input().split()))
result = 0

for c in combinations(arr, 3):
    tmp = sum(c)
    if result<tmp<=M:
        result = tmp # max로 하는게 훨씬 오래걸림
print(result)

'''     내가 푼 알고리즘       '''

import sys
n, m = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))
result = 0
for x in range(n-2):
    for y in range(x+1, n-1):
        for z in range(y+1, n):
            t = arr[x] + arr[y] + arr[z]
            if result < t <= m:
                result = t
print(result)
