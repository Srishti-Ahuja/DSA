class Solution {
    List<List<Integer>> res;

    void buildSuperset(int[] nums, ArrayList<Integer> ans, int idx){
        if(idx==nums.length){
            res.add(new ArrayList<>(ans));
            return;
        }

        //dont include idx
        buildSuperset(nums,ans,idx+1);

        //include idx
        ans.add(nums[idx]);
        buildSuperset(nums,ans,idx+1);
        ans.remove(ans.size()-1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        buildSuperset(nums, new ArrayList<>(), 0);
        return res;
    }
}