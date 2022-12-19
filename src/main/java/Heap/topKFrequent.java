package Heap;

import java.util.ArrayList;
import java.util.List;

public class topKFrequent {
    public static int[] topKFrequent(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            if (min > i) min = i;
            if(i > max) max = i;
        }
        int[] freq = new int[max - min + 1];
        for (int i : nums)
            freq[i - min]++;
        List<Integer>[] buckets = new List[nums.length + 1];
        int max_freq = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                if (buckets[freq[i]] == null)
                    buckets[freq[i]] = new ArrayList<>();
                buckets[freq[i]].add(i + min);

                max_freq = Math.max(freq[i], max_freq);
            }
        }
        int[] res = new int[k];
        for (int i = max_freq, idx = 0; i > 0 && idx < k; i--)
            if (buckets[i] != null)
                for (int num : buckets[i]) {
                    if (idx == k) break;
                    res[idx++] = num;
                }
        return res;
    }
}
