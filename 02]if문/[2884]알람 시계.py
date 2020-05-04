import sys
h, m = map(int, sys.stdin.readline().strip().split())
if m >= 45:
    print(h,m-45)
else:
    if h-1 == -1:
        h = 24
    print(h-1,60-(45-m))