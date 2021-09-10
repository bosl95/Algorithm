## 상호 평가

- 크게 어려운 문제는 아니나 조금 주의해서 봐야할 부분이 있음.
- 자기 자신이 "유일한" 최저점 혹은 최고점이어야함.
- 즉, 다른 사람과 함께 최저점/최고점일 경우 그냥 평균 합산

```java
for (int j = 0; j < scores[0].length; j++) {
        if (i != j && scores[minIdx][i] >= scores[j][i]) {
            minIdx = j;
        }

        if (i != j && scores[maxIdx][i] <= scores[j][i]) {
            maxIdx = j;
        }

            sum += scores[j][i];
        }

        if (minIdx == i) {
            sum = (sum - scores[i][minIdx]) / (scores.length - 1);
        } else if (maxIdx == i) {
            sum = (sum - scores[i][maxIdx]) / (scores.length - 1);
        } else {
            sum = sum / scores.length;
        }
}
```