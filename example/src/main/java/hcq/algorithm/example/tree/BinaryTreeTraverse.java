package hcq.algorithm.example.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树广度优先遍历（二叉树层级遍历）
 * <p>
 * Created by changqiang.huang on 2021/5/21 23:02
 */
public class BinaryTreeTraverse {

    private static class TreeNode {
        final int val;
        final TreeNode left;
        final TreeNode right;

        private TreeNode(int value, TreeNode left, TreeNode right) {
            this.val = value;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode secondLeftLeaf = new TreeNode(4, null, null);
        TreeNode secondRightLeaf = new TreeNode(5, null, null);
        TreeNode secondLeft = new TreeNode(2, secondLeftLeaf, null);
        TreeNode secondRight = new TreeNode(3, null, secondRightLeaf);
        TreeNode root = new TreeNode(1, secondLeft, secondRight);

        List<List<Integer>> result = breadthTraverse(root);

        int size = result.size();
        for (int i = 0; i < size; i++) {
            List<Integer> integers = result.get(i);
            int size2 = integers.size();
            for (Integer integer : integers) {
                if (size2 == 1) {
                    System.out.print("  ");
                }
                System.out.print(integer);
                System.out.print("   ");
            }
            if (i < size - 1) {
                System.out.println();
                System.out.print("/  \\");
                System.out.println();
            }
        }
    }

    public static List<List<Integer>> breadthTraverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            while (size > 0) {
                TreeNode treeNode = queue.poll();
                if (treeNode != null) {
                    list.add(treeNode.val);
                    if (treeNode.left != null) {
                        queue.offer(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        queue.offer(treeNode.right);
                    }
                }
                size--;
            }
            result.add(list);
        }
        return result;
    }
}
