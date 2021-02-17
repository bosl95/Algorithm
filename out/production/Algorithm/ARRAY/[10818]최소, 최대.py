import sys
n = int(sys.stdin.readline().strip())
l = list(map(int, sys.stdin.readline().strip().split()))
print(min(l),max(l))