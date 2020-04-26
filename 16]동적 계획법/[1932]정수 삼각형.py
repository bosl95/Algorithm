N = int(input())
t = [list(map(int, input().split())) for _ in range(N)]
k=2
for i in range(1, N):
    for j in range(k):
        if j==0:
            t[i][j] += t[i-1][j]
        elif i==j:
            t[i][j] += t[i-1][j-1]
        else:
            t[i][j] += max(t[i-1][j-1], t[i-1][j])
    k += 1
print(max(t[N-1]))