package hcq.algorithm.example.string;

/**
 * 所谓对称子字符串，就是这个子字符串要么是以其中一个词对称：比如 “aba”， “abcba”；要么就完全对称：比如"abba", "abccba"。
 * 给你一个字符串，找出该字符串中对称的子字符串的最大长度。
 * <p>
 * Created by changqiang.huang on 2021/5/30 19:55
 */
public class AsymmetricSubString {

    public static void main(String[] args) {
        System.out.println(solution("abccba"));
        System.out.println(solution("abba"));
        System.out.println(solution("abcba"));
        System.out.println(solution("123abba567"));
        System.out.println(solution("123ab345ba567"));
        System.out.println(solution("ab35ba"));
    }

    public static int solution(String original) {
        if (original == null || original.length() == 0) {
            return 0;
        }

        int maxLength = 0;
        int length = original.length();
        for (int i = 0; i < length; i++) {
            int tempMaxLength = 0;
            for (int j = length; j >= 0; j--) {
                // 两个指针向中间移动比较
                int startIndex = length - j + i;
                int endIndex = j - 1;
                if (original.charAt(startIndex) == original.charAt(endIndex) && startIndex < endIndex) {
                    tempMaxLength += 2;
                } else {
                    int difference = endIndex - startIndex;
                    if (tempMaxLength > 0) {
                        if (difference == 0) {
                            // abcba
                            tempMaxLength++;
                        } else if (difference > 0) {
                            // ab35ba
                            tempMaxLength = 0;
                        }
                    }
                    break;
                }
            }
            maxLength = Math.max(tempMaxLength, maxLength);
        }
        return maxLength;
    }
}
