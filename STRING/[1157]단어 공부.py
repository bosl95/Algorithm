# w = input().upper()
# a = {}
# for i in set(w):
#     a[i] = w.count(i)
# A = None
# for k, v in a.items():
#     if v == max(a.values()):
#         if A == None:
#             A = k
#         else:
#             A = '?'
#             break
# print(A)

s = input().upper(); m=0
for i in set(s):
    c=s.count(i)
    if m==c:o='?'
    if m<c:m=c;o=i
print(o)