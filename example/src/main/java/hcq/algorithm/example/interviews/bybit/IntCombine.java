package hcq.algorithm.example.interviews.bybit;

import java.util.ArrayList;
import java.util.List;

/**
 * /**
 * * 问题: 给定一个数 n 与 k, 列出所有 1 ... n 中所有 k 个数的组合
 * *
 * * 范例: n = 4, k = 2
 * *  [1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]
 * *
 * * 变形:
 * *
 * *  顺序不 care
 * *
 * *  顺序 care
 * *
 */
public class IntCombine {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = combine(4, 2);
        for (ArrayList<Integer> list : result) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtracking(n, k, 1, list, result);
        return result;
    }

    public static void backtracking(int n, int k, int start, List<Integer> list, ArrayList<ArrayList<Integer>> result) {
        if (k < 0) {
            return;
        }
        if (k == 0) {
            result.add(new ArrayList<>(list));
        } else {
            for (int i = start; i <= n; i++) {
                list.add(i);
                backtracking(n, k - 1, i + 1, list, result);
                list.remove(list.size() - 1);
            }
        }
    }
}
