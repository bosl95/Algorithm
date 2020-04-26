def fibo(n):
    if n==0: return (1,0)
    if n==1: return (0,1)
    if dp[n] != -1: return dp[n]
    dp[n] = (fibo(n-1)[0] + fibo(n-2)[0], fibo(n-1)[1]+fibo(n-2)[1])
    return dp[n]
for _ in range(int(input())):
    m = int(input())
    dp = [-1]*(m+1)
    print(*fibo(m))