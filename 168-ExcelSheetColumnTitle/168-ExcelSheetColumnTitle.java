// Last updated: 09/07/2026, 10:08:43
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--; 
            char c = (char) (columnNumber % 26 + 'A');
            result.append(c);
            columnNumber /= 26;
        }

        return result.reverse().toString();
    }
}
