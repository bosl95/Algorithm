x = int(input())
# first = 1
# n = 1
# if x == 1:
#     print(1)
#     exit()
# while True:
#     if x <= first:
#         print(n)
#         break
#     first = first + 6 * n
#     n += 1
#
a=c=1
while a<x:
    a +=6*c
    c+=1
print(c)