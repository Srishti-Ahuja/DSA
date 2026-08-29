class Solution {
    List<List<Integer>> res;

    void build(int[] candidates, ArrayList<Integer> ans, int target, int sum, int idx) {
        if(sum==target){
            res.add(new ArrayList<>(ans));
            return;
        }

        if(idx==candidates.length)
            return;

        for(int i=idx; i<candidates.length; i++){
            if(i!=idx && candidates[i-1]==candidates[i])
                continue;

            if(sum+candidates[idx] <= target){
                ans.add(candidates[i]);
                build(candidates, ans, target, sum+candidates[i], i+1);
                ans.remove(ans.size()-1);
            }
        }
        
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();

        Arrays.sort(candidates);
        build(candidates, new ArrayList<Integer>(), target, 0, 0);

        return res;
    }
}