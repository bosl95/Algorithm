def F(x):
    for i in str(x):
        x += int(i)
    return x

set1 = set(range(1,10001));set2 = set()
for i in range(1, 10001):
    set2.add(F(i))

for i in sorted(set1-set2):
    print(i)