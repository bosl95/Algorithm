# Sort

## 정렬 기준

- 오름차순 : 한글 > 소문자 > 대문자  > 숫자
- 내림차순 : 숫자 > 대문자 > 소문자 > 한글

<br>

## Arrays.sort(오름차순)

`Arrays.sort`는 배열을 정렬해준다.<br>

```java
String[] str = {1, 2, 5, 3};
Array.sort(str);
for (String s : str) {
    System.out.println(s);      //   1 2 3 5
}

Arrays.sort(str, Collcetions.reversOrder());    // 내림차순 정렬
for (String s : str) {
    System.out.println(s);      //   5 3 2 1
}

```

<br>

## Collections.sort

Collections.sort는 객체를 정렬해준다.<br>

- `Collections.sort()` : 오름차순
- `Collections.reverse()` : 내림차순

```java
ArrayList<String> list = new ArrayList<String>();
list.add("1");
list.add("2");
list.add("3");
list.add("5");
list.add("4");

Collections.sort(list);

for (String s : list) {
    System.out.println(s);      //   1 2 3 4 5
}

Collections.reverse(list);

for (String s : str) {
    System.out.println(s);      //   5 4 3 2 1
}
```

<br>

### 다른 기준으로 정렬하고 싶은 경우<br>

- `Comparator` 인터페이스를 사용하여 특정 기준의 정렬을 할 수 있다.

    ```java
    Collections.sort(list, new Comparator<Student>() {
                @Override
                public int compare(Student s1, Student s2) {
                    if (s1.score < s2.score) {
                        return -1;
                    } else if (s1.score > s2.score) {
                        return 1;
                    }
                    return 0;
                }
            });
    ```
  
  **Comparator** 객체를 기준으로 정렬을 실행하게된다.<br>
  `compare()` 메소드는 두 객체를 비교하여 음수가 나오면 `o1` 객체가 작다고 판단, 양수가 나오면 크다고 판단한다.
  
<br>
