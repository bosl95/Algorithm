import sys
input=sys.stdin.readline

n = int(input())
heap = set()
for _ in range(n):
    a, b = input().strip().split(' ')
    if b=='enter':
        heap.add(a)
    else:
        heap.remove(a)

for x in sorted(heap, reverse=True):
    print(x)