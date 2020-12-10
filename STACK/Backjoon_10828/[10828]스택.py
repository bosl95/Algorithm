import sys; input=sys.stdin.readline

def solution(k, arr):
    stack = []
    for a in arr:
        if a[:4]=="push":
            stack.append(a.split(' ')[1])
        elif a=="pop":
            print(stack.pop() if stack else -1)
        elif a=="size":
            print(len(stack))
        elif a=="empty":
            print(0 if stack else 1)
        elif a=="top":
            print(stack[-1] if stack else -1)

k = int(input())
arr = [input().strip() for _ in range(k)]
solution(k, arr)