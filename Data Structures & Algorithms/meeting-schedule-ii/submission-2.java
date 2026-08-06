/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        if(n==0) return 0;
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(intervals.get(0).end);
        int currRooms = 1;
        int maxRooms = 1;

        for(int i=1; i<n; i++){
            int currStart = intervals.get(i).start;
            while(!minHeap.isEmpty() && minHeap.peek() <= currStart){
                minHeap.poll();
            }
            minHeap.add(intervals.get(i).end);
            currRooms = minHeap.size();
            maxRooms = Math.max(maxRooms, currRooms);
        }
        return maxRooms;
    }
}
