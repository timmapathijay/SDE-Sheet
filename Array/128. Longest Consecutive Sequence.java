class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
        return 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < nums.length ; i++) // N
        set.add(nums[i]);

        int LongestConsecutiveLength = 0;
        for(int i = 0 ; i < nums.length ; i++) // N
        {
            // ith element is the starting point in the sequence.
            if(!set.contains(nums[i] - 1))
            {
                int sequenceLength = 1;
                int value = nums[i];
                while(set.contains(value + 1)) // N
                {
                    sequenceLength += 1;
                    value += 1;
                }
                LongestConsecutiveLength = Math.max(LongestConsecutiveLength , sequenceLength);
            }  
        }
        return LongestConsecutiveLength;
    }
}

// TC : O(3N)
// SC : O(N)[HashSet]
