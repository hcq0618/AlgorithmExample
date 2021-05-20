package hcq.algorithm.example.digit;

/**
 * 输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。
 * <p/>
 * 例如输入12，从1到12这些整数中包含1 的数字有1，10，11和12，1一共出现了5次。
 * <p/>
 * 谷歌面试题
 * Created by hcq0618 on 2015/12/26.
 */
public class IntCount {

    public static void main(String[] args) {
        solution1(12);
        solution2(12);
    }

    public static void solution1(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            String str = String.valueOf(i);
            int len = str.length();
            for (int j = 0; j < len; j++) {
                char c = str.charAt(j);
                //char转整型为其asic码值 所以char-'0'的asic码值即可转换为整数
                int temp = c - '0';
                if (temp == 1) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public static void solution2(int n) {
        int count = 1;

        //如果这个数字大于10，除以10之后再判断个位数字是不是1
        for (int i = 10; i <= n; i++) {
            int temp = i;
            while (temp > 0) {
                if (temp % 10 == 1) {
                    count++;
                }
                temp = temp / 10;
            }
        }

        System.out.println(count);
    }
}
