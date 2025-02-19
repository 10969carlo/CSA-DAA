import java.util.*;

class HeapDemo {
    public static List<Integer> findKSmallest(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : arr) {
            minHeap.add(num);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(minHeap.poll());
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        System.out.println(findKSmallest(arr, 3)); // [3, 4, 7]
    }
}
