# 최대공약수 GCD(a, b) = G라 했을 때 a=Gx, b=Gy (x, y는 서로소) & a,b의 합집합 = G,x,y
# 최소공배수 LCM(a, b) = G*x*y 이므로
# a*b = G*G*x*y  즉, LCM(a,b)=(a*b)/G

# k = 최소공배수일 때 달력의 마지막 해 <M:N> 이 됨 ==> -1
# x에 M을 계속 더함
# def gcd(a,b):
#     mod = a%b
#     while mod > 0:
#         a = b
#         b = mod
#         mod = a%b
#     return b
#
# for i in range(int(input())):
#     M, N, x, y = map(int, input().split())
#
#     lcm = (M*N)/gcd(M,N)
#
#     while x<lcm:
#         if x%N==y:
#             print(x)
#             break
#         x = x + M
#
#     if x>=lcm:
#         print(-1)

def gyn(m,n,x,y):
    while x<=m*n: # 최대 공배수 쓰면 시간초과 뜸
        if (x-y)%n == 0:
            return x
        x += m
    return -1

tt = int(input())
for _ in range(tt):
    m, n, x, y = map(int, input().split())
    print(gyn(m,n,x,y))