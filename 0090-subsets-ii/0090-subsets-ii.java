class Solution {
    List<List<Integer>> res;

    void build(int[] nums, ArrayList<Integer> ans, int idx){
        res.add(new ArrayList<>(ans));
        if(idx==nums.length){
            return;
        }

        for(int i=idx; i<nums.length; i++){
            if(i!=idx && nums[i-1]==nums[i])
                continue;

            ans.add(nums[i]);
            build(nums, ans, i+1);
            ans.remove(ans.size()-1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        build(nums, new ArrayList<>(), 0);
        return res;
    }
}