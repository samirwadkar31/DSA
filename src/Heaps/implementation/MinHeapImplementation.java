package Heaps.implementation;

public class MinHeapImplementation{
    private int[] heap;
    private int size;

    public MinHeapImplementation(int[] arr) {
        this.heap = arr;
        this.size = arr.length;
        buildHeap();
    }

    private void buildHeap() {
        for (int i = (size / 2) - 1; i >= 0; i--) {
            shiftDown(i);
        }
    }

    public void insert(int value) {
        if (size == heap.length) throw new IllegalStateException("Heap is full!");
        heap[size] = value;
        shiftUp(size);
        size++;
    }

    private void shiftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap[parent] > heap[index]) {
                swap(parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }

    public int removeMin() {
        if (size == 0) throw new IllegalStateException("Heap is empty!");
        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        shiftDown(0);
        return min;
    }

    private void shiftDown(int index) {
        while (index < size) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < size && heap[left] < heap[smallest]) smallest = left;
            if (right < size && heap[right] < heap[smallest]) smallest = right;
            if (smallest == index) break;

            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 15, 30, 40, 5, 3};
        MinHeapImplementation minHeap = new MinHeapImplementation(arr);

        minHeap.printHeap();
        System.out.println("Removed Min: " + minHeap.removeMin());
        minHeap.printHeap();
    }
}
