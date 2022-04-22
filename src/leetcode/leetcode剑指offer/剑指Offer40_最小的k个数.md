## 代码

```java
// 堆排序
// class Solution {

//     int[] ans;
//     int size;

//     public int[] getLeastNumbers(int[] arr, int k) {
//         if (k == 0) return new int[]{};
//         this.ans = new int[k];
//         this.size = k;
//         for (int i = 0; i < k; i++) ans[i] = arr[i];
//         buildHeap();
//         for (int i = k; i < arr.length; i++) {
//             if (ans[0] > arr[i]) {
//                 ans[0] = arr[i];
//                 heapify(0);
//             }
//         }
//         return ans;
//     }

//     private void buildHeap() {
//         for (int i = (size - 2) / 2; i >= 0; i--) {
//             heapify(i);
//         }
//     }

//     private void heapify(int root) {
//         int max = root;
//         int left = root * 2 + 1;
//         int right = root * 2 + 2;
//         if (left < size && ans[left] > ans[max]) max = left;
//         if (right < size && ans[right] > ans[max]) max = right;
//         if (root != max) {
//             swap(ans, root, max);
//             heapify(max);
//         }
//     }

//     private void swap(int[] nums, int i, int j) {
//         int tmp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = tmp;
//     }

// }

// 快排
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1, k);
        int[] ans = new int[k];
        System.arraycopy(arr, 0, ans, 0, k);
        return ans;
    }

    private void quickSort(int[] arr, int left, int right, int k) {
        if (left > right) return;
        int pivotIdx = partition(arr, left, right);
        if (pivotIdx == k - 1) {
            return;
        } else if (pivotIdx < k - 1) {
            quickSort(arr, pivotIdx + 1, right, k);
        } else {
            quickSort(arr, left, pivotIdx - 1, k);
        }
    }

    private int partition(int[] arr, int left, int right) {
        if (left > right) return -1;
        int pivotIdx = left + (int)(Math.random() * (right - left + 1));
        swap(arr, left, pivotIdx);
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) right--;
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) left++;
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
```

## 思路

二分 + 快排

或者 使用堆排序

## 参考

略。