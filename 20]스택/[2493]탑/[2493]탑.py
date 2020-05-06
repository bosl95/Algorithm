import sys;
input=sys.stdin.readline
n = int(input())
tower = list(map(int, input().split()))
s = []
for i in range(n):
    while s:
        if s[-1][1] < tower[i]:
            s.pop()
        else:
            print(s[-1][0], end=" ")
            s.append( (i+1, tower[i]))
            break
    if not s:
        print(0, end=" ")
        s.append( (i+1, tower[i]))