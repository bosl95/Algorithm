def fibo(n):
    global dp
    if n == 1 or n == 0 or dp[n] != -1:
        return dp[n]

    dp[n] = fibo(n-1) + fibo(n-2)

    return dp[n]

def solution(n):
    global dp
    dp = [-1] * (n + 1)
    dp[0] = 0
    dp[1] = 1
    return fibo(n)

print(solution(int(input())))