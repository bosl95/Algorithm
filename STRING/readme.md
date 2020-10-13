# KMP

<image src="https://user-images.githubusercontent.com/34594339/95879820-bf9c5c00-0db1-11eb-960a-a333a822b37f.png" width="70%">

### 맨 앞자리 문자열을 기준으로 방문 비교를 하면 최악의 복잡도는? 

<image src="https://user-images.githubusercontent.com/34594339/95879989-f2deeb00-0db1-11eb-941b-0a657d7100d5.png" width="70%">

### ⇒ 최악의 경우 *O(|A|X|B|)* 이다.<br>
### KMP에서 쓰이는 "실패 함수"를 알면 KMP를 이해하는 데 도움이 된다. <br>

<br>

## 실패 함수

- ###  실패 함수 F(x) : S[0:k] = S[x+1-k:x+1]을 만족하는 최대 k (k<=x)
- ### 문자열 S[0:x+1]에서 접두사와 접미사가 일치하는 최대길이

<br>

- k=x일때, k=x-1일때 , ... 하나씩 해본다.
