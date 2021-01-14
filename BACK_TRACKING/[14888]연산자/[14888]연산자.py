import sys
input = sys.stdin.readline

def dfs(res, a2, op_idx):
    if op[op_idx] == 0:
        return

    op[op_idx] -= 1
    if op_idx == 0:
        res += A[a2]
    elif op_idx == 1:
        res -= A[a2]
    elif op_idx == 2:
        res *= A[a2]
    else:
        res = int(res/A[a2])

    if a2 == n-1:   # A의 마지막 항까지 다 연산 완료
        global Amin, Amax
        Amin = res if Amin > res else Amin
        Amax = res if Amax < res else Amax
    else:
        for i in range(4):
            dfs(res, a2+1, i)
    op[op_idx] += 1


def solution(n, A, op):
    global Amin, Amax
    Amin, Amax= 1000000001, -1000000001
    for i in range(4):
        dfs(A[0], 1, i)

    return [Amax, Amin]


n = int(input())
A = list(map(int, input().split()))
op = list(map(int, input().split()))
op2 = ['+', '-', '*', '//']
for s in solution(n, A, op):
    print(s)