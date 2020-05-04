import sys
n = int(sys.stdin.readline().strip())
line=[0]*n
A = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
A.sort(key=lambda t: t[0])
for i in range(n):
    for j in range(i):
        if A[i][1] > A[j][1] and line[i] <= line[j]:
            line[i] = line[j]
    line[i] += 1
print(n-max(line))

# for i in range(n):
#     num[a[i]] = max(num[:a[i]])+1
# 이거 하면 런타임 에러