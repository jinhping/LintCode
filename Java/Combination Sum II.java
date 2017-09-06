public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public void helper(List<List<Integer>> results, 
                       List<Integer> path, 
                       int[] num,
                       int target,
                       int index)
    {
        if (target == 0) {
            results.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = index; i < num.length; i++) {
            if (i != index && num[i] == num[i - 1]) continue;
            if (num[i] > target) return;
            path.add(num[i]);
            helper(results, path, num, target - num[i], i + 1);
            path.remove(path.size() - 1);
        }
    }
     
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(num);
        List<Integer> path = new ArrayList<>();
        helper(results, path, num, target, 0);
        return results;
    }
}