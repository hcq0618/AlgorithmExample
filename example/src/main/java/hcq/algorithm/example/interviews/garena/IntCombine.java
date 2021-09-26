package hcq.algorithm.example.interviews.garena;

import java.util.Scanner;

/**
 * input:
 * [1,2,3]
 * output:
 * [1,2,3]
 * [1,3,2]
 * [2,1,3]
 * [2,3,1]
 * [3,2,1]
 * [3,1,2]
 * <p>
 * Created by changqiang.huang on 2021/7/13 17:22
 */
public class IntCombine {

    public static void main(String[] args) {
        String input = "[1,2,3]";
        char[] arr = input.toCharArray();
        System.out.print(arr);
        System.out.println();
        solution(arr, 0);
    }

    public static void solution(char[] input, int start) {
        for (int i = start; i < input.length; i++) {
            char x = input[i];
            int value = x - '0';
            if (value < 0 || value > 9) {
                continue;
            }

            for (int j = i + 1; j < input.length; j++) {
                char y = input[j];
                int value2 = y - '0';
                if (value2 < 0 || value2 > 9) {
                    continue;
                }

                input[i] = y;
                input[j] = x;
                solution(input, start + 1);
                System.out.print(input);
                System.out.println();
                input[i] = x;
                input[j] = y;
            }
        }
    }
}
