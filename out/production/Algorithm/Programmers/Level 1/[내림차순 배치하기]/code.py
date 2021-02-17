# 나의 풀이
def solution(s):
    upper = []
    lower = []
    answer = ''
    for alpha in s:
        if alpha.isupper(): upper.append(alpha)
        else:
            lower.append(alpha)
    lower.sort(); upper.sort()
    while lower:
        answer += lower.pop()
    while upper:
        answer += upper.pop()
    return answer

# 다른 사람의 풀이
def solution(s):
    return ''.join(sorted(s, reverse=True))