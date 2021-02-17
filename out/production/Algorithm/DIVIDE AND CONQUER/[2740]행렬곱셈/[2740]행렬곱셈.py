import sys; input = sys.stdin.readline
M , N = map(int, input().split())
A = [list(map(int, input().split())) for _ in range(M)]
N, K = map(int, input().split())
B = [list(map(int, input().split())) for _ in range(N)]
ans = 0
for m in range(M):
    for k in range(K):
        for n in range(N):
            ans += A[m][n] * B[n][k]
        print(ans, end=" ")
        ans = 0
    print()