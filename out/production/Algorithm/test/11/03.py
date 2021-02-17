def solution(A):
    cnt = 0
    n = len(A)
    A.sort()
    for i in range(n, 0, -1):
        if A[-1]!=i: cnt += (i-A[-1])
        A.pop()
        for j in range(len(A)-1, -1, -1):
            if A[j] == i:
                A[j] -= 1; cnt += 1
            else:
                break
    return cnt

print(solution([6, 2, 3, 5, 6, 3]))