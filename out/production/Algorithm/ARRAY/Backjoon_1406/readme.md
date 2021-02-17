# [[1406]에디터](https://www.acmicpc.net/problem/1406)

## Array를 이용한 풀이

- 1차 시도 : 위치를 나타내는 `cursor` 변수를 두고, 삭제/추가를 반복했다.

```java
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        List<String> str = new ArrayList<String>(Arrays.asList(br.readLine().split("")));
        int n = Integer.valueOf(br.readLine());
        int cursor = str.size();
        String command;

        while (n-- > 0) {
            command = br.readLine();
            if (command.equals("L")) {
                cursor = --cursor < 0 ? 0 : cursor;
            } else if (command.equals("D")) {
                cursor = ++cursor > n + 1 ? n + 1 : cursor;
            } else if (command.equals("B")) {
                if (0 < cursor && cursor <= str.size()) {
                    str.remove(cursor-1);
                    --cursor;
                }
            } else {
                str.add(cursor, command.split(" ")[1]);
                ++cursor;
            }
        }
        for (String s : str) { sb.append(s); }
        System.out.println(String.join("", str));
    }
}
```

  그러나 이렇게 될 경우 추가/삭제 될때 다른 원소들의 위치를 이동시켜줘야하므로 효율적이지 않습니다.
  
- 2차 시도 : `ListIterator`를 사용

```java
ListIterator<String> iter = str.listIterator(str.size());

int n = Integer.parseInt(br.readLine());
String command;

while (n-- > 0) {
    command = br.readLine();
    if (command.equals("L")) {
        if (iter.hasPrevious()) {
            iter.previous();
        }
    } else if (command.equals("D")) {
        if (iter.hasNext()) {
            iter.next();
        }
    } else if (command.equals("B")) {
        if (iter.hasPrevious()) {
            iter.previous();
            iter.remove();
        }
    } else {
        iter.add(command.split(" ")[1]);
    }
}
```

  유의할 점 : **`ListIterator`의 `remove()`는 이동한 후의 갖고 있는 값을 제거하는 것이기 때문에, `next()` 혹은 `previous()`를 호출 후에 사용할 수 있습니다.**
  