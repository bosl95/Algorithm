import sys
input=sys.stdin.readline

def solution(n, A):
    res = 1
    dp = [0] * n
    for i in range(n):
        leng = 1
        for j in range(i):
            if A[j] < A[i] and leng < dp[j]+1:
                leng = dp[j]+1
        dp[i] = leng
        if res < dp[i] : res = dp[i]
    return res

n = int(input().strip())
A = list(map(int, input().strip().split()))
print(solution(n, A))