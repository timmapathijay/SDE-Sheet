class Solution {
    public int majorityElement(int[] nums) {
        // Boyer's Moore Algorithm
        // Pairing-Distinct Elements
        int freq = 1;
        int value = nums[0];
        for(int i = 1 ; i < nums.length ; i++)
        {
            if(nums[i] == value)
            freq += 1;
            else
            {
                // Distinct Element 
                if(freq == 0)
                {
                    value = nums[i];
                    freq = 1;
                }
                else
                freq -= 1;
            }
        }
        return value;
    }
}
// TC : O(N)
// SC : O(1)
