n, m = map(int, input().split())
from itertools import permutations
l = list(permutations([x for x in range(1, n+1)], m))
for x in l:
    print(*x)