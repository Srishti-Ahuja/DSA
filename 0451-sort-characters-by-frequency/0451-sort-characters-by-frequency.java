class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        Character[] str = new Character[s.length()];

        for(int i=0; i<s.length(); i++){
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i),0)+1);
            str[i]=s.charAt(i);
        }
        
        Arrays.sort(str, (ch1, ch2)-> {
            int f1 = freq.get(ch1);
            int f2 = freq.get(ch2);
            if (f1 == f2) return Character.compare(ch1, ch2);
            return Integer.compare(f2, f1);
        });

        StringBuilder sb = new StringBuilder();
        for(Character ch: str){
            sb.append(ch);
        }
        return sb.toString();
    }
}