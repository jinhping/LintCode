public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    } 
     
    public void helper(List<List<String>> results, List<String> result, int startIndex, String s) {
        if (startIndex == s.length()) {
            results.add(new ArrayList<String>(result));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String tmp = s.substring(startIndex, i + 1);
            if (!isPalindrome(tmp)) {
                continue;
            }
            result.add(tmp);
            helper(results, result, i + 1, s);
            result.remove(result.size() - 1);
        }
        
    } 
     
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        if (s == null || s.length() == 0) return results; 
        List<String> result = new ArrayList<>();
        helper(results, result, 0, s);
        return results;
    }
}