# [[1182]부분수열의 합](https://www.acmicpc.net/problem/1182)

## Simulation을 이용한 풀이

<image src="https://lh3.googleusercontent.com/uQETugUOTyRD907ginE1B6VmqxQuyXCBS1pNUJ5rdn0cus-ob5RvFHdTFM_Ye4E_jGOy1FEGIf987Y1v1L43TmKCI6gWEi9DW-NdKhqSCRFAlLT5FGVyPx5RvgnKY8edMW6aSHjm" width="70%">

###  1)  2진수를 활용하여 부분 집합을 구하는 방식<br>
### 2) 숏코딩 풀이. x라는 배열에 [0]으로 시작하여 원소들을 하나씩 추가해주면서 x안에 있는 원소들과의 합을 x에 다시 추가하는 방식으로도 풀 수 있다. <br>

<br>

### 시간 복잡도 *O(2<sup>N</sup>xN)* 가 *O(N<sup>2</sup>)* 보다 훨씬 오래 걸린다.

<image src="https://user-images.githubusercontent.com/34594339/96168720-23fb1f00-0f5c-11eb-9082-3e9562c6b429.png" width="70%">

<br>

### 주의할 점은, S=0일 때는 초기화할 때 쓰인 x[0]도 같이 개수에 포함되어버리기때문에 s==0인경우는 빼줘야한다.  <br>

	return x.count(s)-(s==0)	# 한 문장으로 s==0인 경우 체크해주기