n = int(input())
for i in range(n):
    for j in range(n):
        if ((3*i)+(5*j)) == n :
            print(i+j)
            exit()
print(-1)