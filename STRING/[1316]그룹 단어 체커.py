# c = 0; tf = True
# for i in range(int(input())):
#     l = []
#     w = input()
#     before = w[0]
#     for j in w[1:]:
#         print('before', before, 'j', j)
#         if j not in l and before !=j:
#             l.append(before)
#             before = j
#         elif j in l:
#             print("break")
#             tf = False
#             break
#     if tf == True : c +=1
# print(c)
count=0
for i in range(int(input())):
    x = input();tmp = x;chk = True;before='*'
    for w in x:
        if before == w: continue
        tmp = tmp.lstrip(w)
        if tmp.find(w)>0 : chk =False; break
        before = w
    if chk == True : count+=1
print(count)

cnt = 0
for i in range(int(input())):
    word = input()
    cnt += list(word) == sorted(word, key=word.find)
print(cnt)