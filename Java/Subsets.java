public class Solution {
    
    /*
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public void helper(List<Integer> subset, int[] nums, int index, List<List<Integer>> results) {
        results.add(new ArrayList<Integer>(subset));
        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            helper(subset, nums, i + 1, results);
            subset.remove(subset.size() - 1);
        }
    } 
     
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) return results;
        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }
        Arrays.sort(nums);
        helper(new ArrayList<Integer>(), nums, 0, results);
        return results;
    }
}