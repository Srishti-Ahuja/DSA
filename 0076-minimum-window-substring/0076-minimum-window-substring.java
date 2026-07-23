class Solution {
    public String minWindow(String s, String t) {
        if(t.equals(""))
            return "";

        HashMap<Character,Integer> count = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();

        for(int i=0; i<t.length(); i++){
            Character c = t.charAt(i);
            count.put(c, count.getOrDefault(c,0)+1);
        }

        int have=0, need=count.size();
        int[] res = {-1,-1};
        int reslen = Integer.MAX_VALUE;
        int l=0;
        for(int r=0; r<s.length(); r++){
            Character c = s.charAt(r);
            window.put(c, window.getOrDefault(c,0)+1);

            if(count.containsKey(c) && count.get(c).equals(window.get(c)))
                have++;

            while(have==need){
                if(r-l+1<reslen){
                    res[0]=l; res[1]=r;
                    reslen = r-l+1;
                }

                Character lc = s.charAt(l);
                window.put(lc, window.get(lc)-1);
                if(count.containsKey(lc) && count.get(lc)>window.get(lc))
                    have--;
                l++;
            }
        }

        return reslen<Integer.MAX_VALUE ? s.substring(res[0],res[1]+1) : "";
    }
}