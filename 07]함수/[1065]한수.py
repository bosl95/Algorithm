# n = int(input())
# result = n
# if n > 99:
#     result = 99
#     for i in range(100, n+1):
#         i = list(str(i))
#         if int(i[2])-int(i[1]) == int(i[1]) - int(i[0]):
#             result += 1
# print(result)

# 숏코딩 등차수열의 A+C = 2B를 이용
print(sum(i//100+i%10==i//10%10*2 or i<100 for i in range(1,int(input())+1)))
