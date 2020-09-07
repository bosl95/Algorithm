import sys; input = sys.stdin.readline
n = int(input())
H = [ int(input()) for _ in range(n) ]
s = [(n, H[-1])]
H = H[:-1]
cnt = 0
for i in range(n-2, -1, -1):
    flag = False
    while s:
        if H[i] <= s[-1][1]:
            if flag:
                cnt += (s[-1][0] - (i+1) - 1)
            s.append((i+1, H[i]))
            break
        else:   # H[i] > s[-1][1]
            flag = True
            s.pop()
    if flag and not s:
        s.append((i+1, H[i]))
        cnt += ((n+1)-(i+1)-1)
print(cnt)
