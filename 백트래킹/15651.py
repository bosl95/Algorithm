n, m = map(int, input().split())
from itertools import product
l = [list((range(1, n+1)))] * m
for p in product(*l):
    print(*p)