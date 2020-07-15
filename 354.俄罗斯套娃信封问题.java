/*
 * @lc app=leetcode.cn id=354 lang=java
 *
 * [354] 俄罗斯套娃信封问题
 */

// @lc code=start
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int res;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        if (envelopes.length > 0) {
            
        }
        int curr0, int curr1;
        for (int i = 0; i < envelopes.size(); i++) {

        }
    }
}
// @lc code=end

