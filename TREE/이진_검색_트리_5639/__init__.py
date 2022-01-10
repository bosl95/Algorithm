import sys

sys.setrecursionlimit(100000)
input = sys.stdin.readline


def getPostorder(values):
    length = len(values)
    if length <= 1:
        return values

    for j in range(1, length):
        if values[j] > values[0]:  # 오른쪽 노드로 가는 경우
            return getPostorder(values[1:j]) + getPostorder(values[j:]) + [values[0]]  # 왼쪽 - 오른쪽 - 중간

    return getPostorder(values[1:]) + [values[0]]  # 모두 왼쪽 노드로 쏠려있는 경우

nums = []
while True:
    try:
        i = int(input())
        nums.append(i)
    except:
        break

nums = getPostorder(nums)
for n in nums:
    print(n)

