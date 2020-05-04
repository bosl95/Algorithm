import sys;i=sys.stdin.readline;s=[]
for _ in range(int(i())):
    a = int(i())
    if a==0: s.pop()
    else: s.append(a)
print(sum(s))
# 훨씬 빠름

# s=[]
# for _ in range(int(input())):
#     a = int(input())
#     if a==0: s.pop()
#     else: s.append(a)
# print(sum(s))