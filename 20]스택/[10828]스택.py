import sys; input=sys.stdin.readline
arr = [input().split() for _ in range(int(input()))];s = [] # 스택
for a in arr:
    if a[0] == 'push':
        s.append(a[1])
    elif a[0] == 'pop':
        print(s.pop() if s else -1)
    elif a[0] == 'size':
        print(len(s))
    elif a[0] == 'empty':
        print(1 if not s else 0)
    else:   # top
        print(s[len(s)-1] if s else -1)

'''
top에서 런타임 오류가 났었는데
s[-1]로 접근하는 방식이 굉장히 위험하다고 한다.
'''