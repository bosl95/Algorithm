def f(arr, x, y, _n):
    m = arr[x][y]
    for i in range(x, x+_n):
        for j in range(y, y+_n):
            if m!=arr[i][j]:
                return False
    return True

def solution(arr):
    ans = [0, 0]
    n = len(arr)
    if n==1:
        ans[arr[0]] += 1
        return ans
    if f(arr, 0, 0, n):
        ans[arr[0][0]] += 1
        return ans
    n //= 2
    stack = [[0,0], [0, n], [n, 0], [n, n]]

    while n>0:
        tmp = []
        while stack:
            a, b = stack.pop()
            if f(arr, a, b, n):
                ans[arr[a][b]] +=1
            else:
                tmp.append([a, b])
                tmp.append([a+n//2, b])
                tmp.append([a, b+n//2])
                tmp.append([a+n//2, b+n//2])
        n //= 2
        stack = tmp

    return ans

print(solution([[1, 1], [1, 1]]))