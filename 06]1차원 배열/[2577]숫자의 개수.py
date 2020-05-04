import sys
# result=1
# for i in range(3):
#     result = result * (int(sys.stdin.readline().strip()))
# a = [0]*10
# for i in str(result):
#     a[int(i)] +=1
# for i in a:
#     print(i)

i=(lambda:int(sys.stdin.readline().strip()));a=str(i()*i()*i())
for i in range(10):print(a.count(str(i)))

# result=1
# for i in range(3):
#     result = result * (int(sys.stdin.readline().strip()))
# result = str(result)
# for i in range(10):
#     print(result.count(str(i)))