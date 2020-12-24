import sys
input = sys.stdin.readline

def vps(line):
    stack = []
    for w in line:
        if w == '(' or w == '[':
            stack.append(w)
        elif stack and (stack[-1], w) in [('(', ')'), ('[', ']')]:
            stack.pop()
        else:
            return "NO"

    if stack:
        return "NO"

    return "YES"

def solution(n, lines):
    result = []
    for line in lines:
        result.append(vps(line))
    return result

n = int(input().strip())
lines = [list(input().strip()) for _ in range(n)]
for s in solution(n, lines):
    print(s)