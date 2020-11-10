
x = input('문자열 1 : ')
y = input('문자열 2 : ')

n, m = len(x), len(y)
arr = [[0]*(m+1) for _ in range(n+1)]

for i in range(1, n+1):
    for j in range(1, m+1):
        if x[i-1] == y[j-1]:
            arr[i][j] = arr[i-1][j-1] + 1
        else:
            arr[i][j] = max(arr[i-1][j], arr[i][j-1])

print(arr[n][m])