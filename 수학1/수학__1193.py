# x = int(input())
# j=s=0; a, b = 0, 1
# for i in range(1, x+1):
#     if j == s:
#         s += 1; j=1
#         if s%2==0: b +=1
#         else: a+=1
#     else:
#         j+=1
#         if s % 2 != 0:  a -= 1; b += 1
#         else:   a += 1; b -= 1
#
# print('{}/{}'.format(a,b))

'''시간초과 '''

n = int(input())
count = 1
while n > count:
    n -= count
    count += 1
''' 이거 파악하는게 어려웟다ㅏ..'''
if count%2==0:
    x, y = 1, count
    x = x + n - 1
    y = y - n + 1
else:
    x, y = count, 1
    x = x - n + 1
    y = y + n -1
print('{}/{}'.format(x, y))