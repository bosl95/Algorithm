import sys
n = int(sys.stdin.readline().strip())
a = []
for i in range(n):
    x,y = map(int, sys.stdin.readline().strip().split())
    a.append((x,y))
for i in range(n):
    print(a[i][0]+a[i][1])