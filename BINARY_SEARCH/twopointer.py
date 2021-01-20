
# 1. 9개의 서로 다른 수가 주어질 때, 그 중 합이 60인 7개의 수를 고르는 경우의 수를 구하여라

# def twopointer(nlist, snum):
#     answer = []
#     s, e = 0, len(nlist)-1
#     x = sum(nlist)-snum
#
#     while s < e:
#         tmp_sum = nlist[s]+nlist[e]
#         if tmp_sum == x:
#             answer.append([nlist[s], nlist[e]])
#             s += 1
#         else:
#             e -= 1
#     return answer
#
# print('원하는 n-2개의 숫자 합이 나올 수 있는 경우의 수 구하기')
# numlist = list(map(int, input('숫자 리스트를 입력하세요 : ').split()))
# num_sum = int(input('구하고자하는 합을 입력하세요  : '))
#
# print(twopointer(numlist, num_sum))


# 2. n개의 숫자가 주어지고, 이 중에서 숫자가 중복되지 않도록 r개의 연속된 숫자를 선택하는 r의 최댓값을 구하여라

# def tp(nlist):
#     s, e = 0, 1
#     dp = [0] * len(nlist)
#     dp[0] = 1
#
#     while e<len(nlist):
#         flag = True
#         for i in range(e-1, s-1, -1):
#             if nlist[e] == nlist[i]:
#                 s = i + 1
#                 dp[e] = e-i
#                 flag = False
#                 break
#         if flag:
#             if dp[e]==0: dp[e] = dp[e-1]+1
#             e += 1
#     return max(dp)
#
# numlist = list(map(int, input('숫자 리스트를 입력하세요 : ').split())) # 1 4 2 5 4 5 3 2 1
# print(tp(numlist))

# 3. 자연수 n이 주어질 때, n을 연속된 소수의 합으로 나타낼 수 있는 경우의 수를 구하여라.

# def tp(n):
#     ans = 0
#     s, e, nsum = 0, 0, 0
#     primlist = []
#     arr = [False, False] + [True] * (n - 1)
#
#     for i in range(2, n + 1):
#         if arr[i]:
#             primlist.append(i)
#         for j in range(i * i, n + 1, i):
#             arr[j] = False
#
#     while True:
#         if nsum >= n:
#             if nsum == n:
#                 ans += 1
#             nsum -= primlist[s]
#             s += 1
#         elif e == len(primlist):
#             break
#         else:
#             nsum += primlist[e]
#             e += 1
#     return ans
#
# N = int(input('자연수 n을 입력하시오  : '))
# print(tp(N))
