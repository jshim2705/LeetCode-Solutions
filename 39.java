class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationSum1(candidates, target, new ArrayList<>(), new ArrayList<>(), 0);
    }

    private List<List<Integer>> combinationSum1(int[] candidates, int target, List<Integer> temp, List<List<Integer>> out, int index)
    {
        if (target == 0) {
            out.add(new ArrayList<>(temp));
            return out;
        }
        for(; index < candidates.length; index++) {
            if(target - candidates[index] < 0) return out;
            temp.add(candidates[index]);
            combinationSum1(candidates, target - candidates[index], temp, out, index);
            temp.remove(temp.size() - 1);
        }
        return out;
    }
}
