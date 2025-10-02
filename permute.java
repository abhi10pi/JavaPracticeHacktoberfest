import java.util.*;

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int n;
    
    private void solve(int idx, List<Integer> nums) {
        if (idx == n) {
            result.add(new ArrayList<>(nums));
            return;
        }
        
        for (int i = idx; i < n; i++) {
            // swap
            Collections.swap(nums, i, idx);
            
            solve(idx + 1, nums);
            
            // backtrack (swap back)
            Collections.swap(nums, i, idx);
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        
        solve(0, numList);
        
        return result;
    }
}
