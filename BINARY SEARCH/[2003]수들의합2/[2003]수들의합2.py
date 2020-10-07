import sys
input=sys.stdin.readline

def solution(n, m, A):
    low, high, ans, s = 0, 0, 0, 0

    while True:
        if s >= m:
            s -= A[low]
            low += 1
        elif high == n: break
        else:
            s += A[high]
            high += 1
        if s==m: ans += 1

    return ans

N, M = map(int, input().split())
A = list(map(int, input().split()))
print(solution(N, M, A))