package TEST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        System.out.println(Pattern.matches("[가-힣]{2}[가-힣]*역", "다역"));

    }
}
