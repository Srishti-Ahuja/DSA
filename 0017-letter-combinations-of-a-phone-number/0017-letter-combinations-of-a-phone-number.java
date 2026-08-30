class Solution {
    List<String> res;
    HashMap<Character,List<Character>> map;

    void build(String digits, String ans, int idx){
        if(idx==digits.length()){
            res.add(ans);
            return;
        }

        for(Character c: map.get(digits.charAt(idx))){
            build(digits, ans+c, idx+1);
        }
    }

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<String>();
        map = new HashMap<>();
        map.put('2', List.of('a', 'b', 'c'));
        map.put('3', List.of('d', 'e', 'f'));
        map.put('4', List.of('g', 'h', 'i'));
        map.put('5', List.of('j', 'k', 'l'));
        map.put('6', List.of('m', 'n', 'o'));
        map.put('7', List.of('p', 'q', 'r', 's'));
        map.put('8', List.of('t', 'u', 'v'));
        map.put('9', List.of('w', 'x', 'y', 'z'));

        build(digits, "", 0);

        return res;
    }
}