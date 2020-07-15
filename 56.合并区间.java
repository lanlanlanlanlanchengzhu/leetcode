/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 0) {
            return new int[][]{};
        }
        Arrays.sort(intervals, new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                int[] arr1 = (int[]) o1;
                int[] arr2 = (int[]) o2;
                if (arr1[0] == arr2[0]) {
                    return arr1[1] - arr2[1];
                } else {
                    return arr1[0] - arr2[0];
                }
            }
        });
        List<int[]> res = new ArrayList();
        int min = intervals[0][0];
        int max = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (max < intervals[i][0]) {
                // 前面区间已经生效
                res.add(new int[]{min, max});
                min = intervals[i][0];
                max = intervals[i][1];
            } else {
                max = Math.max(max, intervals[i][1]);
            }
        }
        res.add(new int[]{min, max});
        return res.toArray(new int[0][]);
    }
}
// @lc code=end

