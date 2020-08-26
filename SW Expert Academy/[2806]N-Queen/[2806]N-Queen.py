def dfs(x):
    if x==n:
        global result
        result += 1
        return
    for i in range(n):
        if cols[i] + left[x+i] + right[n-1+x-i] == 0:
            cols[i], left[x+i], right[n-1+x-i] = 1, 1, 1
            dfs(x+1)
            cols[i], left[x + i], right[n - 1 + x - i] = 0, 0, 0

def solution(n):
    global cols, left, right
    cols, left, right = [0]*n, [0]*(2*n-1), [0]*(2*n-1)
    global result
    result = 0
    dfs(0)
    return result

T = int(input())

for test_case in range(1, T + 1):
    n = int(input())
    print("#{} {}".format(test_case, solution(n)))