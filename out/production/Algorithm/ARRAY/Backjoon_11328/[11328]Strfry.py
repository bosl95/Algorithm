import sys; input=sys.stdin.readline
n  = int(input())
for _ in range(n):
    a, b = map(list, input().split())
    a.sort(); b.sort()
    if a==b:
        print("Possible")
    else:
        print("Impossible")