package hcq.algorithm.example.search;

/**
 * 二分查找 O(log2n)
 * <p>
 * 也称折半搜索、对数搜索，是一种在有序数组中查找某一特定元素的搜索算法。
 * <p>
 * 搜索过程从数组的中间元素开始，如果中间元素正好是要查找的元素，则搜索过程结束；
 * 如果某一特定元素大于或者小于中间元素，则在数组大于或小于中间元素的那一半中查找，而且跟开始一样从中间元素开始比较。
 * 如果在某一步骤数组为空，则代表找不到。
 * 这种搜索算法每一次比较都使搜索范围缩小一半。
 * <p>
 * Created by changqiang.huang on 2021/5/22 16:37
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.print(binarySearch(array, 7));
    }

    public static int binarySearch(int[] array, int target) {
        if (array.length == 0) {
            return -1;
        }

        int min = 0;
        int max = array.length;

        while (min <= max) {
            //如果这样写 在 min 和 max 很大的时候，max + min > Interger.MAX_VALUE会出现溢出的情况，从而导致数组访问出错。
            //int mid = (max + min) / 2;
            //解决办法
            int mid = min + (max - min) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (target < array[mid]) {
                max = mid - 1;
            } else if (target > array[mid]) {
                min = mid + 1;
            }
        }
        return -1;
    }
}
