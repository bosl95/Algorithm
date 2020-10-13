import sys
input=sys.stdin.readline

def solution(t, p):
    m, n = len(t), len(p)
    s, stack = 0, []

    for i in range(m):
        if t[i] == p[0]:
            if t[i:i+n] == p:
                s += 1
                stack.append(i+1)

    print(s)
    for i in range(s):
        print(stack[i], end=' ')


T = input()
P = input()
solution(T[:-1], P[:-1])