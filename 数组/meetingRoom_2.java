package 数组;

/**
 * 给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],…] (si < ei)
 * 为避免会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。
 * */

import java.util.*;
class meetingRoom_2 {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0) return 0;
        Arrays.sort(intervals,Comparator.comparingInt(o->o[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int rooms = 0;
        for(int i=0; i<intervals.length; i++) {
            minHeap.offer(intervals[i][1]);
            if (intervals[i][0] < minHeap.peek()) {
                rooms ++;
            } else {
                minHeap.poll();
            }
        }
        return rooms;
    }
}

