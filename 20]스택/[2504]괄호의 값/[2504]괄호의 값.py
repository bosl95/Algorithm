def search(line):
    s = []; left_stack = [] # 왼쪽과 오른쪽 쌍이 대칭인지 확인할 left stack
    pre=""

    for w in line:
        if w in ["(", "["]:     # 왼쪽 괄호일 때
            s.append(w)
            left_stack.append(w)
        else:                      # 오른쪽 괄호일 때
            if left_stack:
                if s[-1]=="(" and w==")":
                    s.pop(); left_stack.pop()
                    s.append(2)
                elif s[-1]=="[" and w=="]":
                    s.pop(); left_stack.pop()
                    s.append(3)
                else:   # s[-1] = ], ), int
                    if left_stack[-1]=="(" and w==")":
                        s.append(w)
                        left_stack.pop()
                    elif left_stack[-1]=="[" and w=="]":
                        s.append(w)
                        left_stack.pop()
                    else:
                        return [0]
            else:
                return [0]
    return [0] if left_stack else s

ans = search(input())
if ans[0]==0:
    print(0)
else:
    left = []
    for a in ans:
        if a in [")", "]"]:
            x = "(" if a==")" else "["
            tmp = 0
            while left[-1]!=x:
                tmp += left.pop()
            left.pop()
            left.append(tmp*2 if x=="(" else tmp*3)
        else:
            left.append(a)
    print(sum(left))