package hcq.algorithm.example.interviews.shopee;

import java.util.LinkedList;

public class LRUCache {

    public static void main(String[] args) {
        LRUCacheInternal lruCache = new LRUCacheInternal(3);
        lruCache.add(1);
        lruCache.add(2);
        lruCache.add(3);
        lruCache.display();
        lruCache.add(2);
        lruCache.display();
        System.out.println(lruCache.get(1));
        lruCache.display();
    }

    private static class LRUCacheInternal {

        private final LinkedList<Integer> list = new LinkedList<>();
        private final int maxSize;

        private LRUCacheInternal(int maxSize) {
            if (maxSize <= 0) {
                throw new IllegalArgumentException("maxSize <= 0");
            }
            this.maxSize = maxSize;
        }

        void add(int data) {
            cleanup();
            int index = list.indexOf(data);
            if (index >= 0) {
                list.remove(index);
            }
            list.addFirst(data);
        }

        void cleanup() {
            int size = list.size();
            while (size > maxSize) {
                list.removeLast();
                size = list.size();
            }
        }

        int get(int pos) {
            if (pos < 0 || pos >= list.size()) {
                throw new IndexOutOfBoundsException();
            }
            int data = list.get(pos);
            list.remove(pos);
            list.addFirst(data);
            return data;
        }

        void display() {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
}
