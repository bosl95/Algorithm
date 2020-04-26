# line = input().strip()
# a = 0
# for i in ["c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="]:
#     a += line.count(i)
#     line = line.replace(i, '0')
# print(a+len(line.replace('0',"")))

#print(len(input().replace(i, '*') for i in ["c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="]))

a=input();print(len(a)-sum(a.count(i) for i in ['=','-','lj','nj','dz=']))