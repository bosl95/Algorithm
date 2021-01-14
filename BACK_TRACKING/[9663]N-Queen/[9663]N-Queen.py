def queen(i):
    global result
    k = i + 1

    if i == n-2:
        for l in range(n):
            if left[k+l] + right[n+k-l-1] + col[l] == 0:
                result += 1
                break
        return

    for l in range(n):
        if left[k+l] + right[n+k-l-1] + col[l] == 0:
            left[k+l], right[n+k-l-1], col[l] = 1, 1, 1
            queen(k)
            left[k + l], right[n + k - l - 1], col[l] = 0, 0, 0

def solution(n):
    global result
    result = 0
    if n==1:
        print(1)
    else:
        for i in range(n):
            row[0], col[i], left[i], right[n-i-1] = 1, 1, 1, 1
            queen(0)
            row[0], col[i], left[i], right[n-i-1] = 0, 0, 0, 0

        print(result)

n = int(input())
row, col = [0] * n,  [0] * n
left, right = [0] * (2*n-1), [0] * (2*n-1)
solution(n)