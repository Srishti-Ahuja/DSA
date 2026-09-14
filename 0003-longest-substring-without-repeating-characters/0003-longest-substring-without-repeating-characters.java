class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int i=0, j=0, mx=0;
        while(j<s.length()){
            if(map.containsKey(s.charAt(j))){
                while(i<=map.get(s.charAt(j))){
                    map.put(s.charAt(i), map.get(s.charAt(i)) -1);
                    i++; 
                } 
            }

            map.put(s.charAt(j), j);
            mx = Integer.max(mx, j-i+1);
            j++;
        }

        return mx;
    }
}