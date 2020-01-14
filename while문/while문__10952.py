import sys
a =list(map(int, sys.stdin.readline().strip().split()))
while a != [0,0]:
    print(a[0]+a[1])
    a = list(map(int, sys.stdin.readline().strip().split()))