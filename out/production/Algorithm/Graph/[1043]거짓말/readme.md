# [[1043]거짓말](https://www.acmicpc.net/problem/1043)

## Graph를 이용한 풀이

<image src="https://lh6.googleusercontent.com/rT24T1iafFhXYGEW1962y-X4Dp6DdVclxL-xSfHAAkN2-KmDljws7LNkXyIJcTerfGFvfShbKGVYwaSLMilhrUCQF61A0VfvHC78Qdzdn1Z3BZ8M19Ghvf_6WCTEMUIdt-L_4R4I" width="70%">
<br>

### 단순하게도 풀 수 있는 문제였지만, Graph로 푸는 방법을 연습하기 위해 배우고 있는 방식으로 풀었다. <br>
### 이전에 사용 했던 방법인 [[5214]환승](https://github.com/bosl95/Algorithm/tree/master/Graph/%5B5214%5D%ED%99%98%EC%8A%B9) 문제를 똑같이 사용하여 풀었다.<br>

<br>
<br>

### 다른 사람의 풀이 <br>
#### set 자료형의 함수를 활용하여 간단하게 풀었다.<br>
#### ``intersection()``은 교집합을 구해주는 함수, ``union()``은 합집합을 구해주는 함수로 그때그때 교집합으로 생기는 애들이 있는 파티를 제거해주고 합집합으로 진실을 말해야하는 사람들 배열에 추가하는 방식<br>


	from sys import stdin
	cnt_party = int(stdin.readline().split()[1])
	witness_set = set(stdin.readline().split()[1:])
	  
	party_list = []
	possible_list = []
	  
	for i in range(cnt_party):
	    party_list.append(set(stdin.readline().rstrip().split()[1:]))
	    possible_list.append(1)
	 
	for k in range(cnt_party):
	    for i, party in enumerate(party_list):
	        if witness_set.intersection(party):
	            possible_list[i] = 0
	            witness_set = witness_set.union(party)

	print(sum(possible_list))