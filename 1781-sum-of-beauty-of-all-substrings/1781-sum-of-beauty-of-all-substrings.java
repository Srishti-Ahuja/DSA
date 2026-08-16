class Solution {
    public int beautySum(String s) {
        int sum = 0;
        int len = s.length();

        for(int i=0; i<len; i++){
            HashMap<Character, Integer> hm = new HashMap<>();

            for(int j=i; j<len; j++){
                hm.put(s.charAt(j), hm.getOrDefault(s.charAt(j),0)+1);

                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for(int v:hm.values()){
                    min = Integer.min(min, v);
                    max = Integer.max(max, v);
                }

                sum += max-min;
            }
        }

        return sum;
    }
}