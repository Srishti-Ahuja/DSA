class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int mx=0, start=0;

        for(int i=0; i<s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                start = map.get(s.charAt(i))+1 > start ? map.get(s.charAt(i))+1 : start;
            }

            System.out.println(s.charAt(i)+" "+start+" "+i);
            mx = Integer.max(mx, i-start+1);

            map.put(s.charAt(i), i);
        }
        return mx;
    }
}