public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public void helper(List<List<Integer>> results, 
                       List<Integer> path, 
                       int[] candidates,
                       int target, 
                       int index) 
    {
        if (target == 0) {
            results.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) return;
            if (i != index && candidates[i] == candidates[i - 1]) continue;
            path.add(candidates[i]);
            helper(results, path, candidates, target - candidates[i], i);
            path.remove(path.size() - 1);
        }
    } 
     
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        helper(results, path, candidates, target, 0);
        return results;
    }
}