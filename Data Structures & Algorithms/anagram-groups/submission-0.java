class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        HashMap<String, List<String>> hm = new HashMap<>();
        for(int i=0; i<n; i++){
            String s = strs[i];
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sorted = new String(c);
            if(hm.containsKey(sorted)){
                hm.get(sorted).add(s);
            }
            else{
                hm.put(sorted, new ArrayList<>());
                hm.get(sorted).add(s);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        hm.forEach((key, value) -> {
            ans.add(value);
        });
        return ans;
    }
}
