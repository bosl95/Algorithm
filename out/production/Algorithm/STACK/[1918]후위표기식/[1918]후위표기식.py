def solution(line):
    stack = []
    prior = {'+':0, '-':0, '*':1, '/':1}

    for l in "("+line+")":
        if l == "(":
            stack.append(l)
        elif 'A' <= l <= 'Z':
            print(l, end='')
        elif l == ")":
            while True:
                x = stack.pop()
                if x == "(": break
                print(x, end='')
        else:
            while stack[-1]!='(' and prior[l] <= prior[stack[-1]]:
                print(stack.pop(), end='')
            stack.append(l)

Line = input()
solution(Line)