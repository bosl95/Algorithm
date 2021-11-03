히스토그램에서 가장 넓이가 큰 직사각형을 구하는 프로그램을 작성하시오.  
  (0을 입력하면 종료)
##### 입력 
	7 2 1 4 5 1 3 3 4 
	1000 1000 1000 1000 
	0	
##### 출력  
	 8 
	 4000  

>### 분할정복을 이용한 알고리즘

#### 현재 배열에서 최소 높이를 가지는 높이 h는 전체 밑변 w * h를 가진다.  
#### ==> **높이 오름차 순으로 분할 정복을 시행.**  
* ex1) H = [2, 1, 4, 5, 1, 3, 3] * DAC(H)  
  1. H[1] = 1일 때 최소  
  2. DAC(H[0]), DAC(H[2]~H[6]) 호출  
  3. max(len(H)*H[1], DAC(H[0]), DAC(H[2]~H[6]))  
##### 이 방법을 최대 넓이를 구할때 까지 반복.  
 
> ### code

```python
import sys;input = sys.stdin.readline  
h_arr = []  
while True:  
x = input()  
if x[0]=='0':  
    break  
h_arr.append(list(map(int, x.split()))) # 입력  

def DAC(arr):  
l = len(arr)  
if l == 1: return arr[0]  
else:  
    m = min(arr)  
    idx = arr.index(m)  
    if idx==0:  
	idx += 1  
    return max(DAC(arr[:idx]), DAC(arr[idx:]), l*m)  

for h in h_arr:  
print(DAC(h))
```

예제 출력은 잘 되었지만, 메모리 초과가 발생.
> ### **Stack을 이용한 알고리즘**
###### 최소값을 기준으로 왼쪽 오른쪽을 비교해야 하는 경우의 수를 배열 H의 맨끝에 0을 삽입해주어 위와 같은 왼쪽을 탐색하는 방법을 사용.
> ### code

```python
H = [7, 2, 1, 4, 5, 1, 3, 3]  
s = []; ans = 0  
H.append(0)  

for i, h in enumerate(H):  
    while s and H[s[-1]] > h:    # h보다 작은 값이 나올때까지 실행  
  th = H[s.pop()]  
	w = i-s[-1]-1 if s else i  
	# 스택이 비어있다 : 최소 높이의 인덱스라는 의미이므로 가로는 i 
	# 아닌 경우는 i에서 s의 top인 인덱스를 빼준다.  
  if ans < th*w: ans = th*w  
    s.append(i)  
print(ans)
```
	
>3 3 4 3 (..?)
