import sys
n = int(sys.stdin.readline().strip())
result = 0
# if n%2 != 0 : # n이 홀수
#     print((n+1)*(n//2)+((n+1)//2))
# else:
#     print((n+1)*(n//2))

for i in range(n):
    result = result + (i+1)
print(result)

# 둘다 시간, 메모리 같음.