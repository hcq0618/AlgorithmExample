package hcq.algorithm.example.interviews.shopee;

/**
 * 假设 A -> 1, B->2, …… Z->26,  输入一个只包含数字的字符串， 问映射成字母可以有多少种可能性，比如“123” 可以看成是1、2、3或者12、3或者1、23 但是“06"没有可以映射的字母 只有“6”才可以映射成F
 * <p>
 * Created by changqiang.huang on 2021/6/24 20:29
 */
public class CharacterMapping {

    public static void main(String[] args) {
        System.out.println(solution("12"));
        System.out.println(solution("226"));
        System.out.println(solution("0"));
        System.out.println(solution("06"));
    }

    private static int solution(String original) {
        int result = 1;
        int length = original.length();
        for (int i = 0; i < length; i++) {
            char c = original.charAt(i);
            if (isValidDigit(c)) {
                int diff = 0;
                for (int j = i + 1; j < length; j++) {
                    char next = original.charAt(j);
                    if (!isValidDigit(next)) {
                        return 0;
                    }
                    if (!isValidRange(c, next)) {
                        return 0;
                    }
                    diff = 1;
                }
                result += diff;
            } else {
                return 0;
            }
        }
        return result;
    }

    private static boolean isValidDigit(char c) {
        int value = c - '0';
        return value > 0 && value <= 9;
    }

    private static boolean isValidRange(char c, char next) {
        int value = (c - '0') * 10 + (next - '0');
        return value > 0 && value <= 26;
    }
}
