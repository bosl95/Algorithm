import sys; input=sys.stdin.readline
n, k = map(int, input().split())
cnt = 0
stu = [[0, 0] for _ in range(6) ]
for _ in range(n):
    s, y = map(int, input().split())
    stu[y-1][s] += 1

for i in range(6):
    for j in range(2):
        if stu[i][j]==0:
            continue
        elif stu[i][j]%k==0:
            cnt += stu[i][j]//k
        elif stu[i][j]%k!=0:
            cnt += (stu[i][j]//k + 1)
print(cnt)