n = int(input());index=0
a = [input() for i in range(n)]
for line in a:
    count = 0
    a[index] = 0
    for i in range(len(line)):
        if line[i] == "O":
            count += 1
        else:
            count = 0
        a[index] += count
    print(a[index])
    index += 1
