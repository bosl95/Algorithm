# [[9934]완전 이진 트리](https://www.acmicpc.net/problem/9934)

- 구간 [1,2^k] : 트리의 depth는 최대 k

```python
def inorder(depth):
    global idx, buildings

    if depth == n:
        return

    inorder(depth + 1)
    tree[depth].append(buildings[idx])
    idx += 1
    inorder(depth + 1)
```

- depth는 0부터 시작하기 때문에 n이면 탐색을 종료한다.
- 첫번째 inorder(depth+1)은 좌측 자식 노드가 있을 수도 있다는 가정하에 +1된 depth로 들어간다.
- 그 다음 중간 노드를 저장한다. (`tree[depth].append(buildings[idx])`)
- 그 다음 오른쪽 자식 노드도 마찬가지로 +1된 depth로 들어가 탐색한다.