class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    static void findCombinations(int ind, int[] cand, int target, List<List<Integer>> ans, List<Integer> ds) {
        if(target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for (int i = ind; i < cand.length; i++) {
            if (i > ind && cand[i] == cand[i - 1]) continue;
            if (cand[i] > target) break;

            ds.add(cand[i]);
            findCombinations(i + 1, cand, target - cand[i], ans, ds);
            ds.remove(ds.size() - 1);
        }
    }
}
