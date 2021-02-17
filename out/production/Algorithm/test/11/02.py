def check(A, B):
    for i in range(len(A)):
        if A[i]==B[i]:
            return i
    return -1

def solution(S):
    n = len(S)
    for i in range(n-1):
        for j in range(i+1, n):
            chk = check(S[i], S[j])
            if chk != -1: return [i, j, chk]
    return []


print(solution(["zzzz", "ferz", "zdsr", "fgtd"]))