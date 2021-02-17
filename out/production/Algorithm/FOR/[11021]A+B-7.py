import sys
for i in range(int(sys.stdin.readline().strip())):
    a, b = map(int, sys.stdin.readline().strip().split())
    print("Case #%d : %d"% (i+1, (a+b)))