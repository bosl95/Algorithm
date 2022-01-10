# [[5639]이진 검색 트리](https://www.acmicpc.net/problem/5639)

### 무한 입력 받기

```python
while True:
    try:
        i = int(input())
        nums.append(i)
    except:
        break
```

### 순서 정렬하기

```python
    for j in range(1, length):
        if values[j] > values[0]:  # 오른쪽 노드로 가는 경우
            return getPostorder(values[1:j]) + getPostorder(values[j:]) + [values[0]]  # 왼쪽 - 오른쪽 - 중간
```

- 현재 중간 노드는 values[0]
- 만약 values[1:]을 탐색하던 중 중간 노드보다 큰 값을 발견하면 오른쪽 노드로 이동시켜줘야한다.
- BUT 후위 순회이므로 `왼쪽 + 오른쪽 + 중간 노드` 순이다.
- 중간 노드는 하나이기때문에 `[values[0]]`
- 왼쪽, 오른쪽 노드들은 `values[1:j]`, `values[j:]` 이므로 정렬이 필요하다 => 재귀 호출!

### 모두 왼쪽 정렬되어 있는 경우

```python
return getPostorder(values[1:]) + [values[0]]  # 모두 왼쪽 노드로 쏠려있는 경우
```

- 중간 노드인 `values[0]`보다 모두 왼쪽에 있는 경우
- for문을 빠져나왔다 => `중간 노드보단 작은 애들이다`라는 것이지, 또 정렬이 필요하다.
- 따라서 위와 같이 왼쪽 노드들(`values[1:]`)을 정렬해주고 그 뒤에 중간 노드를 넣어준다. (후위 순회)