package hcq.algorithm.example;

/**
 * 输入一个字符串，输出该字符串中字符的所有组合 例如：输入abc，则组合为a,ab,abc,ac,bc,b,c
 * Created by hcq0618 on 2015/12/25.
 */
public class StringCombine {

    public void solution1(String origin) {
        int len = origin.length();
        for (int j = 0; j < len; j++) {
            String temp = origin.substring(0, j + 1);
            combine1(temp, 0);
        }
    }

    //分两部分考虑 全部相连的组合a,ab,abc,ab,bc,b,c 和有间隔的组合ac
    private void combine1(String origin, int begin) {
        if (begin < origin.length()) {
            System.out.println(origin.substring(begin
            ));

            //输出有间隔的组合ac
            String first = origin.substring(begin, begin + 1);
            for (int i = begin + 2; i < origin.length(); i++) {
                System.out.println(first + origin.substring(i));
            }
        } else {
            return;
        }

        //递归就能输出全部相连的组合a,ab,abc,bc,b,c
        combine1(origin, begin + 1);
    }

}
