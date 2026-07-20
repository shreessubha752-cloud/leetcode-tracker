// Last updated: 20/07/2026, 10:13:25
class Solution {
    public boolean isNumber(String s) {
        s = s.trim(); // remove leading/trailing spaces
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExp = false;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                seenDigit = true;
            } 
            else if (c == '+' || c == '-') {
                // sign is only valid at start or right after exponent
                if (i > 0 && !(s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {
                    return false;
                }
            } 
            else if (c == '.') {
                // dot not allowed after exponent or if already seen
                if (seenDot || seenExp) {
                    return false;
                }
                seenDot = true;
            } 
            else if (c == 'e' || c == 'E') {
                // exponent only once, must follow a digit
                if (seenExp || !seenDigit) {
                    return false;
                }
                seenExp = true;
                seenDigit = false; // reset, must see digit after exponent
            } 
            else {
                return false; // invalid character
            }
        }
        
        return seenDigit;
    }
}
