def solution(s1, s2):
    n1, n2 = len(s1), len(s2)
    dp = [0] * (n1+1)

    for i in range(1, n2+1):
        tmp = [0] * (n1+1)
        for j in range(1, n1+1):
            if s1[j-1] == s2[i-1]:
                tmp[j] = dp[j-1] + 1
            else:
                tmp[j] = max(tmp[j-1], dp[j])
        dp = tmp.copy()
    return dp[-1]

s1 = list(input())
s2 = list(input())
print(solution(s1, s2))