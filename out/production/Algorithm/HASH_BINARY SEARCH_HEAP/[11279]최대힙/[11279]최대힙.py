import sys
import heapq as h
input=sys.stdin.readline

N = int(input())
heap = []
for _ in range(N):
    x = int(input())
    if x ==0: print(0 if heap==[] else -h.heappop(heap))
    else: h.heappush(heap, -x)
