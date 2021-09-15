import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<int[]> values = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int num = entry.getKey();
            int frequent = entry.getValue();
            values.add(new int[]{num, frequent});
        }

        int[] ans = new int[k];
        Collections.shuffle(values);
        qSort(values, 0, values.size() - 1, ans, 0, k);
        return ans;
    }

    private void qSort(List<int[]> values, int lo, int hi, int[] ans, int ansIndex, int k) {
//        if (lo > hi) {
//            return;
//        }
        int pivot = partition(values, lo, hi);
        if (k < pivot - lo + 1) {
            qSort(values, lo, pivot - 1, ans, ansIndex, k);
        } else {
            for (int i = lo; i <= pivot; i++) {
                ans[ansIndex++] = values.get(i)[0];
            }
            if (k > pivot - lo + 1) {
                qSort(values, pivot + 1, hi, ans, ansIndex, k - (pivot - lo + 1));
            }
        }
    }

    private int partition(List<int[]> values, int lo, int hi) {
        int[] tmp = values.get(lo);
        while (lo < hi) {
            while (lo < hi && values.get(hi)[1] <= tmp[1]) hi--;
            values.set(lo, values.get(hi));
            while (lo < hi && values.get(lo)[1] >= tmp[1]) lo++;
            values.set(hi, values.get(lo));
        }
        values.set(lo, tmp);
        return lo;
    }


    public static void main(String[] args) {
        List<int[]> l = new ArrayList<>();
        l.add(new int[]{0, 0 });
        int[] ans = new int[1];
        Solution s = new Solution();
        s.qSort(l, 0, -1, ans, 0, 0);

    }

}