// Last updated: 20/07/2026, 10:13:28
import java.util.*;

class Solution {
    public String getPermutation(int n, int k) {
        // Precompute factorials
        int[] fact = new int[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
        }
        
        // List of numbers to pick from
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        
        // Convert k to 0-based index
        k--;
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = n; i >= 1; i--) {
            int idx = k / fact[i - 1];
            sb.append(numbers.get(idx));
            numbers.remove(idx);
            k %= fact[i - 1];
        }
        
        return sb.toString();
    }
}
