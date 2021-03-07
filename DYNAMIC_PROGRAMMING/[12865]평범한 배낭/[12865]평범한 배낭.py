import sys
input = sys.stdin.readline

def solution(n, k, stuff):
    dp = [0] * (k+1)

    for w, v in stuff:
        if k>=w:
            for i in range(k, w-1, -1):
                dp[i] = max(dp[i], v+dp[i-w])
    return max(dp)


n, k = map(int, input().strip().split())
stuff = [list(map(int, input().strip().split())) for _  in range(n)]
print(solution(n, k, stuff))