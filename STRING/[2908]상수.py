# a, b = input().split()
# for i in range(2, -1, -1):
#     if a[i] > b[i]: A=a[2]+a[1]+a[0]; break
#     elif b[i] > a[i]: A=b[2]+b[1]+b[0]; break
# print(A)

print(max(input()[::-1].split()))