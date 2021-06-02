package hcq.algorithm.example.string;

import java.util.Stack;

/**
 * Given a string s containing only three types of characters:'(',')'and'*', return true if s is valid.
 * The following rules define a valid string:
 * • Any left parenthesis'('must have a corresponding right parenthesis')'.
 * • Any right parenthesis')'must have a corresponding left parenthesis'('.
 * • Left parenthesis'('must go before the corresponding right parenthesis')'.
 * • '*' could be treated as a single right parenthesis')'or a single left parenthesis'('or an empty string"".
 * <p>
 * Inputs:
 * (()) true
 * (*) true
 * (*)) true
 * (*)) true
 * (())() true
 * )( false
 * (***((* false
 * *(" false
 * (*** true
 * <p>
 * Created by changqiang.huang on 2021/6/2 11:18
 */
public class StringParenthesis {

    public static void main(String[] args) {
        System.out.println(solution("(())"));
        System.out.println(solution("(*)"));
        System.out.println(solution("(*))"));
        System.out.println(solution("(())()"));
        System.out.println(solution(")("));

        System.out.println(solution("(***((*"));
        System.out.println(solution("*("));
        System.out.println(solution("(***"));
    }

    public static boolean solution(String original) {
        if (original.isEmpty()) {
            return true;
        }

        int length = original.length();
        // store index
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();

        //O(n)
        for (int i = 0; i < length; i++) {
            char c = original.charAt(i);
            if (c == '(') {
                left.push(i);
            } else if (c == '*') {
                star.push(i);
            } else {
                if (!left.isEmpty()) {
                    left.pop();
                } else if (!star.isEmpty()) {
                    star.pop();
                } else {
                    return false;
                }
            }
        }

        // *(
        while (!left.isEmpty() && !star.isEmpty()) {
            if (left.peek() > star.peek()) {
                return false;
            }
            left.pop();
            star.pop();
        }

        return true;
    }
}
