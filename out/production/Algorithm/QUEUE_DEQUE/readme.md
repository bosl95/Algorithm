# Queue

- ### Queue 선언

    ```java
    import java.util.LinkedList; //import
    import java.util.Queue; //import
    
    Queue<Integer> stack = new LinkedList<>(); //int형 queue 선언, linkedlist 이용
    Queue<String> stack = new LinkedList<>(); //String형 queue 선언, linkedlist 이용
    ```

- ### Queue 값 추가

    ```java
    Queue<Integer> stack = new LinkedList<>(); //int형 queue 선언
    queue.add(1);     // queue에 값 1 추가
    queue.add(2);     // queue에 값 2 추가
    queue.offer(3);   // queue에 값 3 추가
    ```
  
  `add()`는 예외를 발생시키고, `offer`은 값을 리턴합니다.(`true/false`)
  
- ### Queue 값 삭제

    ```java
    Queue<Integer> queue = new LinkedList<>(); //int형 queue 선언
    queue.offer(1);     // queue에 값 1 추가
    queue.offer(2);     // queue에 값 2 추가
    queue.offer(3);     // queue에 값 3 추가
    queue.poll();       // queue에 첫번째 값을 반환하고 제거 비어있다면 null
    queue.remove();     // queue에 첫번째 값 제거
    queue.clear();      // queue 초기화
    ```
  
- ### Queue에 가장 먼저 들어간 값 출력

    ```java
    Queue<Integer> queue = new LinkedList<>(); //int형 queue 선언
    queue.offer(1);     // queue에 값 1 추가
    queue.offer(2);     // queue에 값 2 추가
    queue.offer(3);     // queue에 값 3 추가
    queue.peek();       // queue의 첫번째 값 참조
    ```
  
<br>

| |예외 발생|값 리턴|
|:---:|:---:|:---:|
|추가(enqueue)|add(e)|offer(e)|
|삭제(dequeue)|remove()|poll()|
|검사(peek)|element()|peek()|




