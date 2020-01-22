# import sys;from itertools import permutations
# n = int(sys.stdin.readline())
# arr = list(map(int, sys.stdin.readline().split()))
# calc = list(map(int, sys.stdin.readline().split()))
# operator = ['+', '-', '*', '//']
# tmp = list(operator[i] for i in range(4) for _ in range(calc[i]))
# result = []
#
# for s in list(set(permutations(tmp))):
#     r = arr[0]
#     for i in range(len(s)):
#         if s[i] == '+':
#             r += arr[i+1]
#         elif s[i] == '-':
#             r -= arr[i+1]
#         elif s[i] == '*':
#             r *= arr[i+1]
#         else:
#             r = abs(r) // arr[i+1]
#             if r < 0: r = -r
#     if -1000000000 <= r <= 1000000000:
#         result.append(r)
#
# print(max(result))
# print(min(result))
'''
풀긴 풀었는데 자꾸 틀렸다고 처리됨..(테스트 케이스는 통과)
밑의 코드 (인터넷)으로 통과 ㅜ_ㅜ
'''

import sys
input = sys.stdin.readline

def calc(num, idx, add, sub, multi, division):
    global maxv, minv
    if idx == n:
        maxv = max(num, maxv)
        minv = min(num, minv)
    else:
        if add:
            calc(num + num_list[idx], idx+1, add-1, sub, multi, division)
        if sub:
            calc(num - num_list[idx], idx + 1, add, sub-1, multi, division)
        if multi:
            calc(num * num_list[idx], idx + 1, add, sub, multi-1, division)
        if division:
            calc(int(num/num_list[idx]), idx + 1, add, sub, multi, division-1)

if __name__ == "__main__":
    maxv = -sys.maxsize - 1
    minv = sys.maxsize
    n = int(input().strip())
    num_list = list(map(int, input().strip().split()))
    a, b, c, d = map(int, input().strip().split())
    calc(num_list[0], 1, a, b, c, d)
    print(maxv)
    print(minv)