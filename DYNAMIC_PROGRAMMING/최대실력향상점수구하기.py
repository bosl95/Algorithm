def knapsack(arr, k):
    dp = [0] * (k+1)

    for time, score in arr:
        if k >= time:
            for i in range(k, time-1, -1):
                dp[i] = max(dp[i], score+dp[i-time])
    return dp


k = int(input('k를 입력하시오  : '))
arr = []

while True:
    a, b = map(int, input('재생시간과 실력향상점수를 입력하시오(종료 -1 -1) : ').split())
    if a==-1 and b==-1: break
    arr.append([a, b])

print(knapsack(arr, k))