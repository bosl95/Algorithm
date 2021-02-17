import sys; input=sys.stdin.readline

def solution(n, arr):
    result = []
    stack = []
    j = 0

    for i in range(1, n+1):
        while stack and stack[-1] == arr[j]:
            stack.pop()
            result.append('-')
            j += 1
        stack.append(i)
        result.append('+')

    while stack:
        if stack.pop()==arr[j]:
            j += 1
            result.append('-')
        else:
            return ["NO"]
    return result

n = int(input())
arr = [int(input()) for _ in range(n)]
for s in solution(n, arr):
    print(s)


