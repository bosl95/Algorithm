import sys

input = sys.stdin.readline


def inorder(depth):
    global idx, k, nums, tree
    if depth == k:
        return

    inorder(depth + 1)
    tree[depth].append(nums[idx])
    idx += 1
    inorder(depth + 1)


k = int(input())
nums = list(map(int, input().split()))
idx = 0
tree = [[] for _ in range(k)]

inorder(0)
for t in tree:
    print(*t)
