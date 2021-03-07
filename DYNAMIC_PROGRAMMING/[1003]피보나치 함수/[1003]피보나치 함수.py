def fibo(x):
    global dp
    if x == 0 or x == 1 or dp[x] != [-1, -1]:
        return dp[x]

    x1, y1 = fibo(x-1)
    x2, y2 = fibo(x-2)
    dp[x] = [x1+x2, y1+y2]
    return dp[x]

def solution(n):
    global dp
    dp = [[1, 0], [0, 1]]+ [[-1, -1]] * (n-1)
    return fibo(n)

t = int(input())
for _ in range(t):
    print(*solution(int(input())))