''' 내가 푼 알고리즘 '''
n, m = map(int, input().split())
from itertools import permutations
l = list(permutations([x for x in range(1, n+1)], m))
for x in l:
    tmp = tuple(sorted(x))
    if tmp == x:
        print(*x)

''' 더 빠른 숏코딩 '''
from itertools import combinations  # permutation과 달리 순서 중복 제거
n, m = map(int, input().split())
for x in combinations(range(1, n+1), m):
    print(*x)