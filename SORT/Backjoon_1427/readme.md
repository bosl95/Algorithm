# [[1427]소트인사이드](https://www.acmicpc.net/problem/1427)

## Sort를 이용한 풀이

- 문제 해결 방식

1. 입력받은 문자열을 각각 원소로 만들어 리스트로 만든다.

        String[] stringArray = String.valueOf(N).split("");

2. 정수로 바꿔준다.

        for (String s : stringArray) {
                    intArray.add(Integer.parseInt(s));
                }

3. 리스트를 내림차 순으로 정렬한다.

        intArray.sort(Comparator.reverseOrder());

4. 문자열 answer에 리스트 원소를 추가해준다.
    
        for (int x : intArray) {
                    answer += String.valueOf(x);
                }

        System.out.println(answer);

<br>

## 다른 사람의 풀이

- String 입력값을 받고 Array로 바꾸는 부분 (`toCharArray()` 유의해두자!!)

        String str = sc.next();
		char[] ch = str.toCharArray();
		
- Arrays.sort를 이용해 정렬하고 거꾸로 출력한다.

        Arrays.sort(ch);
		for(int i=ch.length-1; i>=0; i--)
			System.out.print(ch[i]);

<br>

엄청 차이나는 코드는 아니지만 훨씬 깔끔하게 구현할 수 있는 코드여서 참고해보았다.<br>