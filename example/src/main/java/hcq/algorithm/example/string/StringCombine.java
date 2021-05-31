package hcq.algorithm.example.string;

/**
 * 输入一个字符串，输出该字符串中字符的所有组合 例如：输入abc，则组合为a,ab,abc,ac,bc,b,c
 * Created by hcq0618 on 2015/12/25.
 */
public class StringCombine {

    public static void main(String[] args) {
        solution("abc");
    }

    public static void solution(String origin) {
        int len = origin.length();
        for (int j = 0; j < len; j++) {
            String temp = origin.substring(0, j + 1);
            combine(temp, 0);
        }
    }

    //分两部分考虑 全部相连的组合a,ab,abc,bc,b,c 和有间隔的组合ac
    private static void combine(String origin, int begin) {
        if (begin < origin.length()) {
            String result = origin.substring(begin);
            System.out.println(result);

            //输出有间隔的组合ac
            String first = origin.substring(begin, begin + 1);
            for (int i = begin + 2; i < origin.length(); i++) {
                result = first + origin.substring(i);
                System.out.println(result);
            }
        } else {
            return;
        }

        //递归就能输出全部相连的组合a,ab,abc,bc,b,c
        combine(origin, begin + 1);
    }

}
