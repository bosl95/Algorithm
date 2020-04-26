import sys;input=sys.stdin.readline
in_list = list(input().strip() for _ in range(int(input())))
def f_stack(str):
    stack_l = [];
    for s in list(str):
        if s=='(': stack_l.append(s)
        else:
            if stack_l: stack_l.pop()
            else: return "NO"
    if stack_l: return "NO"
    else: return "YES"
for l in in_list:
    print(f_stack(l))

