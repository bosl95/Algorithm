# def solution(s):
#     n = len(s)
#     ans = 0
#     for i in range(n):
#         t, cnt = -1, 0
#         for j in range(n-1, i, -1):
#             if s[i]==s[j]:
#                cnt += 1
#             else:
#                 ans += (j-i)
#                 t = j-i if t < j-i else t
#                 ans += (t*cnt)
#                 cnt = 0
#
#     return ans

def count(str):
    n = len(str)
    ans = 0
    for i in range(n-1):
        for j in range(n-1, i, -1):
            if str[i]!=str[j]:
                ans = max(j-i, ans)
    return ans


def solution(s):
    n = len(s)
    ans = 0
    for i in range(n):
        for j in range(i + 1, n+1):
            ans += count(s[i:j])
    return ans

print(solution("baby"))