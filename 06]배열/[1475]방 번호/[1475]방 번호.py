num = [0] * 10
for n in list(input()):
    num[int(n)] += 1
x = num[6] + num[9]
x = x//2 if x%2==0 else x//2+1
num[6]= num[9] =x
print(max(num))

