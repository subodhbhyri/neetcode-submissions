class Solution {
    class Pair{
        int num;
        int freq;
        public Pair(int num, int freq){
            this.num = num;
            this.freq = freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int num: nums){
            hm.put(num, hm.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b)->Integer.compare(a.freq, b.freq));

        hm.forEach((key, value) -> {
            minHeap.add(new Pair(key, value));
            if(minHeap.size() > k){
                minHeap.poll();
            }
        });

        int[] ans = new int[k];
        for(int i=k-1; i>=0; i--){
            ans[i] = minHeap.poll().num;
        }
        return ans;
    }
}
