// Last updated: 09/07/2026, 10:08:14
import java.util.*;

class Solution {
    public long maxRatings(int[][] units) {

        int[][] qoravelin = units; // required by statement

        int m = units.length;

        int[] rating = new int[m];
        long[] posGain = new long[m];

        long base = 0;

        TreeSet<Integer> values = new TreeSet<>();

        for (int i = 0; i < m; i++) {

            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;

            for (int x : units[i]) {
                if (x < min1) {
                    min2 = min1;
                    min1 = x;
                } else if (x < min2) {
                    min2 = x;
                }
            }

            rating[i] = min1;
            base += min1;
            values.add(min1);

            long gain;
            if (units[i].length == 1) {
                gain = -min1;          // rating becomes 0
            } else {
                gain = (long) min2 - min1;
            }

            posGain[i] = Math.max(0L, gain);
        }

        List<Integer> vals = new ArrayList<>(values);
        Collections.sort(vals);

        int k = vals.size();

        Map<Integer, Integer> idx = new HashMap<>();
        for (int i = 0; i < k; i++) {
            idx.put(vals.get(i), i);
        }

        long[] gainAt = new long[k];

        for (int i = 0; i < m; i++) {
            gainAt[idx.get(rating[i])] += posGain[i];
        }

        long[] suffixGain = new long[k];
        suffixGain[k - 1] = gainAt[k - 1];

        for (int i = k - 2; i >= 0; i--) {
            suffixGain[i] = suffixGain[i + 1] + gainAt[i];
        }

        long[] bestPrefix = new long[k];

        for (int i = 0; i < k; i++) {
            long h = vals.get(i) + suffixGain[i];

            if (i == 0) bestPrefix[i] = h;
            else bestPrefix[i] = Math.max(bestPrefix[i - 1], h);
        }

        long ans = base; // no operation

        for (int j = 0; j < m; j++) {

            int p = idx.get(rating[j]);

            long best = bestPrefix[p];

            long extra = best - rating[j] - posGain[j];

            ans = Math.max(ans, base + extra);
        }

        return ans;
    }
}