# arr = [-1]*26
# word = list(input())
# for i in word:
#     arr[ord(i)-97] = word.index(i)
# print(*arr)

print(*map(input().find,map(chr,range(97,123))))