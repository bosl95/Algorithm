import sys
a = list(map(int, sys.stdin.readline().strip().split()))
a.sort()
print(a[1])