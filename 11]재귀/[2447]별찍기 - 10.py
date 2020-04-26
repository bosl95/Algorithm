#1
# import sys
# n = int(sys.stdin.readline().strip())
# def star(x,y):
#     while(x>0):
#         if x%3==1 and y%3==1:
#             sys.stdout.write(' ')
#             return None
#         x = x//3
#         y = y//3
#     sys.stdout.write('*')
# for i in range(n):
#     for j in range(n):
#         star(i,j)
#     sys.stdout.write('\n')
#2
n=int(input())
a = ['*']
while n>1:
    b = []
    for i in a:
        b.append(i*3)
    for i in a:
        b.append(i+' '*len(a)+i)
    for i in a:
        b.append(i*3)
        a = b
    n //= 3
print(*a, sep='\n')

# 2번 방법이 훨씬 빠름