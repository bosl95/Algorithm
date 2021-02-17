import sys
input=sys.stdin.readline

def solution(n, A, B, C, D):
    X, Y, ans = {}, {}, 0
    for i in range(n):
        for j in range(n):
            x = A[i]+B[j]
            # if not X[x]:
            if not X.get(x):    # get을 사용하여 keyerror를 방지한다.
                X[x] = 1
            else:
                X[x] += 1

            y = C[i]+D[j]
            if not Y.get(y):
                Y[y] = 1
            else:
                Y[y] += 1

    for i in X.keys():
        if Y.get(-i):
            ans += (X[i]*Y[-i])

    return ans

n = int(input())
A, B, C, D = [], [], [],  []
for _ in range(n):
    a, b, c, d = map(int, input().split())
    A.append(a)
    B.append(b)
    C.append(c)
    D.append(d)
print(solution(n, A, B, C, D))