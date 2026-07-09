// Last updated: 09/07/2026, 10:08:21
import java.util.*;

class Solution {

    public int getLength(int[] nums) {

        int[] dremovical = nums;

        int n = nums.length;
        int ans = 1;

        for (int i = 0; i < n; i++) {

            HashMap<Integer, Integer> freq = new HashMap<>();
            TreeMap<Integer, Integer> freqCount = new TreeMap<>();

            for (int j = i; j < n; j++) {

                int x = nums[j];

                int oldFreq = freq.getOrDefault(x, 0);

                if (oldFreq > 0) {
                    int c = freqCount.get(oldFreq);
                    if (c == 1) freqCount.remove(oldFreq);
                    else freqCount.put(oldFreq, c - 1);
                }

                int newFreq = oldFreq + 1;
                freq.put(x, newFreq);

                freqCount.put(newFreq,
                        freqCount.getOrDefault(newFreq, 0) + 1);

                int len = j - i + 1;

                if (freq.size() == 1) {
                    ans = Math.max(ans, len);
                } else if (freqCount.size() == 2) {

                    int minFreq = freqCount.firstKey();
                    int maxFreq = freqCount.lastKey();

                    if (maxFreq == 2 * minFreq) {
                        ans = Math.max(ans, len);
                    }
                }
            }
        }

        return ans;
    }
}