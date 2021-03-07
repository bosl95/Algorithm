import sys
input = sys.stdin.readline

def solution(n, arr):
    arr.sort(key=lambda x:x[0])
    dp = [0] * n
    res = -1
    for i in range(n):
        leng = 1
        for j in range(i):
            if arr[i][1] > arr[j][1] and leng < dp[j] + 1:
                leng = dp[j]+1
        dp[i] = leng
        if res < leng : res = leng

    return n - res

n = int(input().strip())
arr = [list(map(int, input().strip().split())) for _ in range(n)]
print(solution(n, arr))