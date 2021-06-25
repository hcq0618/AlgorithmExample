package hcq.algorithm.example.interviews.lazada;

/**
 * 两个字符串换a和b 如果可以交换a中的两个字符 使得a与b相等 则返回true 否则返回false
 * 1<=a.length, b.length<=2*104
 * a和b中都是小写字母
 * <p>
 * Example:
 * a="ab", b="ba", true
 * a="ab", b="ab", false
 * a="aa", b="aa", true
 * a="aaaaaaabc", b="aaaaaaacb", true
 * <p>
 * Created by changqiang.huang on 2021/5/31 23:47
 */
public class SwapString {

    public static void main(String[] args) {
        System.out.println(swap("ab", "ba"));
        System.out.println(swap("ab", "ab"));
        System.out.println(swap("aa", "aa"));
        System.out.println(swap("aaaaaaabc", "aaaaaaacb"));
    }

    public static boolean swap(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        int length = a.length();
        for (int i = 0; i < length - 1; i++) {
            char a1 = a.charAt(i);
            char b1 = b.charAt(i);
            boolean result = true;

            for (int j = i + 1; j < length; j++) {
                char a2 = a.charAt(j);
                char b2 = b.charAt(j);

                if (j == i + 1) {
                    if (a1 != b2 || a2 != b1) {
                        result = false;
                        break;
                    }
                } else if (a2 != b2) {
                    result = false;
                    break;
                }
            }

            if (result) {
                return true;
            }
        }

        return false;
    }
}
