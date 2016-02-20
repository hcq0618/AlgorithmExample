package hcq.algorithm.example;

/**
 * 输入一个表示整数的字符串，把该字符串转换成整数并输出。例如输入字符串"345"，则输出整数345。
 * <p/>
 * 微软面试题
 * <p/>
 * Created by hcq0618 on 2015/12/25.
 */
public class String2Int {

    public void string2Int(String origin) {

        int firstChar = origin.charAt(0);
        //判断是否为负数
        boolean isNegative = firstChar == '-';

        //判断是否带符号 若是 则先转成无符号
        if (isNegative || firstChar == '+') {
            origin = origin.substring(1);
        }

        int result = 0;
        int len = origin.length();
        for (int i = 0; i < len; i++) {
            char c = origin.charAt(i);
            //char转整形为其asic码值 整数+48为其asic码值 所以char-48为其整数
            int n = c - 48;

            //n^len-i-1
            result += n * Math.pow(10, len - i - 1);
        }

        System.out.println("string2Int:" + (isNegative ? -result : result));
    }

}
