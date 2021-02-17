# [[1181]단어 정렬](https://www.acmicpc.net/problem/1181)

## Sort를 이용한 풀이

- Arrays.sort를 이용한다.
- 이때, Comparator를 이용하여 길이를 체크해준다.
  
        Arrays.sort(stringArray, new Comparator<String>() {
                    @Override
                    public int compare(String s1, String s2) {
                        if (s1.length() == s2.length()) {
                            return s1.compareTo(s2);
                        }
        
                        return s1.length() - s2.length();
                    }
        });
        
- compareTo() : 문자열의 사전순 값을 비교하여 그에 해당하는 int 값 리턴
    - A = B : 0
    - A > B : 1     (ex. `"BB".compareTo("AA")`)
    - A < B : -1    (ex. `"AA".compareTo("BB")`)
    
        
<br>

## 참고

- [https://lookingfor.tistory.com/entry/%EC%9E%90%EB%B0%94-%EB%AC%B8%EC%9E%90%EC%97%B4-%EB%B9%84%EA%B5%90-%ED%95%A8%EC%88%98-compare-compareTo](https://lookingfor.tistory.com/entry/%EC%9E%90%EB%B0%94-%EB%AC%B8%EC%9E%90%EC%97%B4-%EB%B9%84%EA%B5%90-%ED%95%A8%EC%88%98-compare-compareTo)
- [https://ifuwanna.tistory.com/232](https://ifuwanna.tistory.com/232)