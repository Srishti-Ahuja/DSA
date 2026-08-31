class Solution {
    List<String> res;
    void dfs(int target, long curr, long prev, int idx, String num, String exp) {
        if(idx==num.length()){
            if(target==curr)
                res.add(exp);
            return;
        } 

        int i=idx;
        while(i<num.length()){
            if(i>idx && num.charAt(idx)=='0')
                return;

            String val = num.substring(idx, i+1);
            long curr_val = Long.parseLong(val);

            if(exp==""){
                dfs(target, curr_val, curr_val, i+1, num, val);
            }
            else{
                dfs(target, curr + curr_val, curr_val, i+1, num, exp+"+"+val);
                dfs(target, curr - curr_val, -1*curr_val, i+1, num, exp+"-"+val);
                dfs(target, curr -prev + (prev * curr_val), (prev * curr_val), i+1, num, exp+"*"+val);
            }

            i++;
        }
    }
    public List<String> addOperators(String num, int target) {
        res = new ArrayList<>();
        dfs(target, 0, 0, 0, num, "");
        return res;
    }
}