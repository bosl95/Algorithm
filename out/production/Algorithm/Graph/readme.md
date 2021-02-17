# Graph

## :pushpin: Concept


완전 그래프         |  연결 그래프
:-------------------------:|:-------------------------:
<image src="https://user-images.githubusercontent.com/34594339/93023669-809cae80-f62b-11ea-93e6-e364b4d4455d.png" width="70%">  |   <image src="https://user-images.githubusercontent.com/34594339/93024665-efc9d100-f632-11ea-9b53-99350e206c24.png" width="70%">
<br>

#### *cf)* 단순 그래프(Simple graph) : 두 정점 사이의 간선이 1개 이하이고 루프가 존재 하지 않는 그래프
<br>

### 그래프의 표현법
#### 01) 인접 행렬(Adjaceny Matrix)
<image src="https://user-images.githubusercontent.com/34594339/93024859-687d5d00-f634-11ea-8de6-5bacf16b6bcf.png" width="70%">
<br>

- 정점 V개, 간선 E개에서 두 점이 연결되었는지 확인 ⇒ ***O(1)*** 의 시간 복잡도
- 2차원 배열이 필요하기 때문에 ***O(V<sup>2</sup>)*** 의 공간 복잡도
- 모든 정점의 목록을 알아내고 싶은 경우 ⇒ ***O(V)*** 의 시간 복잡도
- 두 점을 잇는 간선이 여러개 일 경우 문제가 발생한다.
<br>

#### 02) 인접 리스트(Adjacency List)
<image src="https://user-images.githubusercontent.com/34594339/93025071-f9a10380-f635-11ea-99b6-6143f5d32bbe.png" width="70%">
<image  src="https://user-images.githubusercontent.com/34594339/93025073-ff96e480-f635-11ea-956e-2b5bd23fdf92.png" width="70%">
<br>

- 정점 V가 크고 간선 E가 상대적으로 작은 상황에서 공간을 절약할 수 있는 방식
- **코딩 테스트에서 인접 행렬보다 훨씬 많이 사용된다**
- ***O(V+E)*** 의 공간 복잡도
	- 예를 들어, V = 100,000 / E = 200,000  이라고 했을 때 인접 행렬의 경우 100,000 x 100,000이 필요하지만 인접리스트는 200,000 ~ 400,000 사이로 메모리가 절약된다.
	
<br>
<image src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcdIHWV%2FbtqADIxert1%2F6zOIBkzRx5kXgneu3sxLMK%2Fimg.png" width="80%"> 

- 인접리스트의 경우한 정점에 대해 자신과 연결된 모든 정점을 확인해야 하는 데 둘 중 차수가 작은 것을 하는 것이 좋으므로 min을 사용한다.
- **구현이 간단하는 것 외에 인접행렬을 사용해서 얻는 이점이 없다고 볼 수 있으며 99% 이상의 경우 인접 리스트로 그래프로 나타낸다.**