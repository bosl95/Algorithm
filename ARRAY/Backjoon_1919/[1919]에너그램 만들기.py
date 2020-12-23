str1 = list(input())
str2 = list(input())
tmp = []
for s1 in str1:
    if s1 in str2:
        str2.pop(str2.index(s1))
    else:
        tmp.append(s1)
print(len(tmp)+len(str2))