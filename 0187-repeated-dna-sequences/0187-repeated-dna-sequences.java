class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<=s.length()-10; i++){
            map.put(s.substring(i, i+10), map.getOrDefault(s.substring(i, i+10),0)+1);
        }

        map.forEach((k,v) -> {
            if(v>1) res.add(k);
        });

        return res;
    }
}