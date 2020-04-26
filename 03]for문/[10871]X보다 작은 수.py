import sys
a, b = map(int, sys.stdin.readline().strip().split())
l = list(map(int, sys.stdin.readline().strip().split()))
for i in l:
    if i < b:
        print(i, end=" ")