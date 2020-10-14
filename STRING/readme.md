
# KMP 

<image src="https://user-images.githubusercontent.com/34594339/95879820-bf9c5c00-0db1-11eb-960a-a333a822b37f.png" width="70%">

### 맨 앞자리 문자열을 기준으로 방문 비교를 하면 최악의 복잡도는? 

<image src="https://user-images.githubusercontent.com/34594339/95879989-f2deeb00-0db1-11eb-941b-0a657d7100d5.png" width="70%">

### ⇒ 최악의 경우 *O(|A|X|B|)* 이다.<br>


<br>

- ### KMP 알고리즘 

	<image src="https://lh5.googleusercontent.com/k2gmDtZd8mWtwwPkUthlmcJ53gYyiAiK2WwkxhYWPSYvawLiSagokoQjDYuCtXr__FdDbXdXInAC2wyKm2LJ803xvR2Xu1pvSLRho79Mgk9TWnLYft_h8vtXghcm7r2vG1bNJZ0c" width="70%">

- ### 개념이 잘 이해가지 않아 다른 자료를 참고 하였다. ( [링크](https://ssungkang.tistory.com/entry/Algorithm-KMP-Knuth-Morris-Pratt-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98) )

	<image src="https://lh4.googleusercontent.com/UHurv_yOo35EBsMyJrxfxwzx2cShpgreLJqL0B92TXIkyBZoXEMpAaG0ZwruJNxaBpbw6RePXlyEnpyvjM_0FNyI4kXX2yziAu5URxXJqEVoybuWYQBZeZt4kNm9HvHHeh4Gt9fk" width="70%">  

- ### 실패 함수 만들기

	<image src="https://user-images.githubusercontent.com/34594339/96023651-b4b6f980-0e8d-11eb-86ab-112dee76476c.png" width="70%">

	- P[i] != P[j] 라면 j = F[j-1] (F 배열을 0으로 초기화 되어있으므로 수정할 필요 X)

	<image src="https://user-images.githubusercontent.com/34594339/96023717-d1533180-0e8d-11eb-8557-0c5e2f8e8a37.png" width="70%">
	
	<image src="https://user-images.githubusercontent.com/34594339/96023762-e16b1100-0e8d-11eb-8c29-96ce267a0270.png" width="70%">
	
	- P[i]==P[j] 이면 F[i] = j+1 하고 j + 1 증가 

 	<image src="https://user-images.githubusercontent.com/34594339/96024686-06ac4f00-0e8f-11eb-95e1-5ae6c97964f9.png" width="70%">

 	<image src="https://user-images.githubusercontent.com/34594339/96024775-2ba0c200-0e8f-11eb-8dc4-a701903adcc6.png" width="70%">

	### ⇒ F(2)=1 임을 이용하여 2칸 이동 할 수 있다.

 	<image src="https://user-images.githubusercontent.com/34594339/96026685-d3b78a80-0e91-11eb-96ef-6932571f6e58.png" width="70%">

 	<image src="https://user-images.githubusercontent.com/34594339/96026760-edf16880-0e91-11eb-8935-d1e228ffc8df.png" width="70%">

	### F(1)=0 이용하여 1칸 이동한다.

 	<image src="https://user-images.githubusercontent.com/34594339/96027108-5e988500-0e92-11eb-9e55-8ea8018f68c2.png" width="70%">
 	
 	<image src="https://user-images.githubusercontent.com/34594339/96027117-62c4a280-0e92-11eb-9f25-f21c674c425a.png" width="70%">
 	
 	<image src="https://user-images.githubusercontent.com/34594339/96027124-66582980-0e92-11eb-8241-7902a49070f3.png" width="70%">

### 매번 비교가 일어날 때마다 i가 1 증가하거나 밑의 문자열이 오른쪽으로 이동하므로 시간복잡도는 *O(|S|)* 이다.

<br>

- ### 실패 함수 이용해서 풀어보기

 	<image src="https://user-images.githubusercontent.com/34594339/96027511-f007f700-0e92-11eb-9af1-88b9e1d89f69.png" width="70%">

 	<image src="https://user-images.githubusercontent.com/34594339/96027572-04e48a80-0e93-11eb-8497-a188989903af.png" width="70%">

	### index=5 일 때 문자가 같지 않으므로, <br>
	### 실패함수 F[4]=3 (중복 문자열이 5개이므로 F[4])를 이용하여 j = 3<br>

 	<image src="https://user-images.githubusercontent.com/34594339/96027911-948a3900-0e93-11eb-9162-6157fce6bf7f.png" width="70%">

 	<image src="https://user-images.githubusercontent.com/34594339/96027926-99e78380-0e93-11eb-8410-f673491a6dcf.png" width="70%">

	### 마찬가지로 index=5 일 때 F[4]=3 이므로 j =3 <br>

- ### 매칭이 완료되는 경우
		
	<image src="https://user-images.githubusercontent.com/34594339/96028333-1a0de900-0e94-11eb-809f-5db39283a2bf.png" width="70%">

	<image src="https://user-images.githubusercontent.com/34594339/96029840-2a26c800-0e96-11eb-8300-d8e648666666.png" width="70%">
	
	### 가장 최대 실패 함수 값 F[7] = 3이므로 j =3

	<image src="https://user-images.githubusercontent.com/34594339/96029935-49bdf080-0e96-11eb-973c-ef8b71a95877.png" width="70%">
	
	### 문자열을 벗어나면 불가능하므로 끝난다.<br>

