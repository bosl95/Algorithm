# [[6118]숨바꼭질](https://www.acmicpc.net/problem/6118)

## Graph 를 이용한 풀이
<image src="https://lh5.googleusercontent.com/ZDfz5OPH2_JgT6EWxYgfuLRjTFnw9xFRJ1ZJF06NtcKrfpFP-kh8RNfSY8YcLK5lz79nlV0MkOpRMeOCWIzyf4EngzseI2qqTBh7LACyVCscRsSQU4fkAill79HfrsBzGPwSBAEP" width="70%">
<br>

### Graph + BFS를 이용해서 풀어야 하는 문제.
#### 마지막에 방문하는 노드들(stack)이 최종 방문하게 될 최대 거리를 갖는 노드들이 된다.
#### 추가적으로 stack에 한칸 이동할 노드들이 담긴 tmp로 치환할때  stack과 tmp의 주소가 같아지기 때문에 tmp.copy()를 사용했었는데<br>
#### ``tmp=[]``로 선언하는 부분에서 tmp 주소값이 새로 할당되므로 copy()함수를 쓰지 않아도 된다.