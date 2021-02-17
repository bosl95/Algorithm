import sys
from heapq import *
input=sys.stdin.readline

N = int(input())
h = []
for _ in range(N):
    x = int(input())
    if x == 0: print(heappop(h) if h!=[] else 0)
    else: heappush(h, x)