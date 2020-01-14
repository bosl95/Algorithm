# a = 0
# for i in input().strip():
#     x = ord(i)-65
#     if x>=0 and x<=2:
#         a += 3
#     elif x>=3 and x<=5:
#         a += 4
#     elif x>=6 and x<=8:
#         a += 5
#     elif x>=9 and x<=11:
#         a += 6
#     elif x>=12 and x<=14:
#         a += 7
#     elif x>=15 and x<=18:
#         a += 8
#     elif x>=19 and x<=21:
#         a += 9
#     elif x>=22 and x<=25:
#         a += 10
# print(a)
# print(ord('Z'))
# for c in input():
#     print(min(ord(c)-64, 25))

dial = ['ABC', 'DEF', 'GHI', 'JKL', 'MNO', 'PQRS', 'TUV', 'WXYZ']
a = input()
ret = 0
for j in range(len(a)):
    for i in dial:
        if a[j] in i:
            ret += dial.index(i)+3
print(ret)
# 인터넷에서 가져옴
# 숏코딩 있는데 봐도 모르겠음