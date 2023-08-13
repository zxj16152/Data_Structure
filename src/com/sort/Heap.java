package com.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 默认大顶堆
 */
public class Heap {
    //某个数在index,继续往上移动
    public void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    //某个数在index位置，能否往下移动
    public void heapify(int[] arr, int index, int heapSize) {
        int cLeft = index * 2 + 1;
        int cRight = index * 2 + 2;
        while (cLeft < heapSize) {//下方还有孩子
            //左右两孩子比较
            int largest = cRight < heapSize && arr[cRight] > arr[cLeft] ? cRight : cLeft;
            largest = arr[index] > arr[largest] ? index : largest;

            if (largest == index) {
                break;
            }
            swap(arr, index, largest);
            index = largest;
            cLeft = index * 2 + 1;
            cRight = index * 2 + 2;
        }

    }

    public void buildHeap(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
    }

    public void heapSort(int[] arr) {
        buildHeap(arr);
        int heapSize = arr.length;
        while (heapSize > 0) {
            swap(arr, 0, --heapSize);
            heapify(arr, 0, heapSize);
        }

    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void testPriorityQueue() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(3);
        queue.offer(1);
        queue.offer(4);
        queue.offer(2);
        queue.offer(5);
        for (Integer integer : queue) {
            System.out.println(integer);
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        int[] a = {3, 1, 4, 2, 5, 2};
//        heap.heapInsert(a, a.length - 1);
        heap.heapSort(a);
        System.out.println(Arrays.toString(a));
        heap.testPriorityQueue();
    }
}
