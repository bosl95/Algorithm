n = int(input())
dp = [-1]*(n+1)

def fibo(m):
    if m == 0: return 0
    if m == 1: return 1
    if dp[m] != -1: return dp[m]

    dp[m] = fibo(m-2) + fibo(m-1)
    return dp[m]
# 동적 계획법
print(fibo(n))

# 내가 다시 풀었당 ^^
n = int(input())
dp = [-1]*(n+1)
def fibo(n):
    if n==0 or n==1: return n
    if dp[n] != -1: return dp[n]
    dp[n] = fibo(n-1) + fibo(n-2)
    return dp[n]
print(fibo(n))