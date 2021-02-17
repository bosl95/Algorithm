
def solution(S):
    if 'aaa' in S:
        return -1
    if S=='a' or S=='aa':
        return 0
    n = len(S)
    if 'a' not in S:
        return 2*(n+1)
    ans = 0
    S = 'x'+S+'x'
    for i in range(1, n+2):
        if S[i]=='a':
            if S[i-1]!='a' and S[i+1]!='a':
                ans += 1
        else:
            if S[i-1]!='a':
                ans += 2
    return ans

print(solution('aabba'))