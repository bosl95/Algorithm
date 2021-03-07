def solution(s1, s2):
    n1, n2 = len(s1), len(s2)
    dp = [[""] * (n2+1) for _ in range(n1+1)]

    for i in range(1, n1+1):
        for j in range(1, n2+1):
            if s1[i-1] == s2[j-1]:
                dp[i][j] = dp[i-1][j-1]+s1[i-1]
            else:
               if len(dp[i-1][j]) > len(dp[i][j-1]):
                   dp[i][j] = dp[i-1][j]
               else:
                   dp[i][j] = dp[i][j-1]

    if dp[n1][n2]:
        print(len(dp[n1][n2]))
        print(dp[n1][n2])
    else:
        print(0)

str1 = input()
str2 = input()
solution(str1, str2)