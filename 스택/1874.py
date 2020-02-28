import sys;input=sys.stdin.readline;n=int(input())
S = [int(input()) for _ in range(n)]
n_s=[];check_s=[];j=0
for i in range(1,n+1):
    n_s.append(i)
    check_s.append("+")
    while n_s and n_s[-1]==S[j]:
        n_s.pop()
        check_s.append("-")
        j += 1
if n_s: print("NO")
else:
    for s in check_s:
        print(s)