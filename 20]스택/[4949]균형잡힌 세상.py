L=[];stack=[]
while True:
    string = input()
    if string==".": break
    stack.append([ s for s in string if s in ['(','[',')',']'] ])
def check(s_l):
    tmp_s = []
    for s in s_l:
        if s=="(" or s=="[": tmp_s.append(s)
        elif tmp_s and ((s=="]" and tmp_s[-1]=="[") or (s==")" and tmp_s[-1]=="(")): tmp_s.pop()
        else: return "no"
    if tmp_s: return "no"
    else: return "yes"
for s in stack:
    print(check(s))