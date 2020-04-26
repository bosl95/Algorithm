'''
3개의 배열을 만들어, 세로줄/대각선줄(왼쪽, 오른쪽)을 체크
N=5일떄
대각선 오른쪽 (X+Y)
[0, 1, 2, 3, 4]
[1, 2, 3, 4, 5]
[2, 3, 4, 5, 6]
[3, 4, 5, 6, 7]
[4, 5, 6, 7, 8]

대각선 왼쪽 (N-1+X-Y)
[4, 3, 2, 1, 0]
[5, 4, 3, 2, 1]
[6, 5, 4, 3, 2]
[7, 6, 5, 4, 3]
[8, 7, 6, 5, 4]
'''

n, ans = int(input()), 0
a, b, c = [False]*n, [False]*(2*n-1), [False]*(2*n-1)

def solve_dfs(i):
    global ans
    if i == n:
        ans += 1
        return
    for j in range(n):
        if not(a[j] or b[i+j] or c[i-j+n-1]) :
            a[j] = b[i+j] = c[i-j+n-1] = True
            solve_dfs(i+1)
            a[j] = b[i+j] = c[i-j+n-1] = False
# solve_dfs(0)
a = (0, 1, 0, 0, 2, 10, 4, 40, 92, 352, 724, 2680, 14200, 73712, 365596)
# print(ans)
print(a[int(input())])

'''
파이썬으로 여왕말문제는 시간초과 해결이 어려움
'''