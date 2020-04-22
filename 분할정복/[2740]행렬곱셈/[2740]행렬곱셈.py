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
'''
크기가 100이라 3중 for문으로 충분히 처리 가능.
슈트라센 알고리즘을 이용해 분할정복을 할 수도 있으나,
안정성이 떨어진다고함.
'''