package com.algorithm.LeetCode热题HOT100;

import java.util.Arrays;

/**
 * @ClassName LC252
 * @Description 252. 会议室
 * @Author bill
 * @Date 2022/3/23 16:41
 * @Version 1.0
 **/
public class LC252 {

    //判断区间是否重叠  重叠区间
    //给定一个会议时间安排的数组 intervals ，
    //每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，
    //请你判断一个人是否能够参加这里面的全部会议。
    public boolean canAttendMeetings(int[][] intervals) {
        // 将区间按照会议开始实现升序排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        // 遍历会议，如果下一个会议在前一个会议结束之前就开始了，返回 false。
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }
        return true;
    }
}
