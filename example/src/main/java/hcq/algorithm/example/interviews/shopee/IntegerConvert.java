package hcq.algorithm.example.interviews.shopee;

import java.util.Stack;

/**
 * nesting depth
 * 021 -> 0((2)1)
 * 312 -> (((3))1(2))
 * <p>
 * 4 -> ((((4))))
 * 221 -> ((22)1)
 * 221 -> ((2)) (2)) (1)   <- wrong
 * <p>
 * 0000 -> 0000
 * 101 -> (1)0(1)
 * 111000 -> (111)000
 * 1 -> (1)
 * <p>
 * 123 -> (1(2(3)))
 * <p>
 * 3112 -> (((3))11(2))
 * <p>
 * 5223 -> (((((5)))22(3)))
 * <p>
 * Created by changqiang.huang on 2021/6/28 17:18
 */
public class IntegerConvert {
    public static void main(String[] args) {
        System.out.println(solution("021"));
        System.out.println(solution("312"));
        System.out.println(solution("4"));
        System.out.println(solution("221"));
        System.out.println(solution("0000"));
        System.out.println(solution("101"));
        System.out.println(solution("111000"));
        System.out.println(solution("1"));
        System.out.println(solution("123"));
        System.out.println(solution("3112"));
        System.out.println(solution("5223"));
    }

    public static String solution(String input) {
        int len = input.length();
        if (len <= 0) {
            return "";
        }

        int leftCount = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char c = input.charAt(i);
            int num = c - '0';
            int needLeftCount = num;
            if (stack.size() > 0) {
                char last = stack.peek();
                int lastNum = last - '0';
                if (lastNum >= 0 && lastNum <= 9) {
                    needLeftCount = num - (last - '0');
                    leftCount = 0;
                }
            }
            while (leftCount < needLeftCount) {
                stack.push('(');
                leftCount++;
            }
            stack.push((char) (num + '0'));

            if (i + 1 < len) {
                char next = input.charAt(i + 1);
                int nextNum = next - '0';
                if (nextNum < num) {
                    num -= nextNum;
                } else {
                    continue;
                }
            }

            for (int j = 0; j < num; j++) {
                stack.push(')');
            }
        }

        int size = stack.size();
        StringBuilder sb = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            sb.append(stack.pop());
        }

        return sb.reverse()
                .toString();
    }
}
