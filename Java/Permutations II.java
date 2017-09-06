class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) return results;
        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        int[] visited = new int[nums.length];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = 0;
        }
        helper(results, path, nums, visited);
        return results;
    } 
    
    public void helper(List<List<Integer>> results, List<Integer> path, int[] nums, int[] visited) {
        if (path.size() == nums.length) {
            results.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1 || (i != 0 && nums[i] == nums[i-1] && visited[i-1] == 0)) {
                continue;
            }
            visited[i] = 1;
            path.add(nums[i]);
            helper(results, path, nums, visited);
            path.remove(path.size() - 1);
            visited[i] = 0;
        }
    }
}


