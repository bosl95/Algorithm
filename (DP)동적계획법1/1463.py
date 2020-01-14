# n = int(input())
# arr = [n]
# count = 0
# def f(x):
#     list = []
#     for i in x:
#         if i%3 == 0:
#             list.append(i/3)
#         if i%2 == 0:
#             list.append(i/2)
#         list.append(i-1)
#     return list
#
# while True:
#     if n==1:
#         print(count)
#         break
#     arr = f(arr)
#     count += 1
#     if min(arr) == 1:
#         print(count)
#         break

# 숏코딩중에 알아들을 만한거
l = [int(input())]; n=0
while 1 not in l:
    t=set(); n+=1   # set이 핵심인 거 같네 지린다.
    for i in l:
        if i%3==0: t.add(i//3)
        if i%2==0: t.add(i//2)  # 나누기로는 안됨 왜지감쟈? 플롯으로 나와서 안되나봄
        t.add(i-1)
    l=t
print(n)