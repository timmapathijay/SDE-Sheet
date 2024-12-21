class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // Boyer's Moore Algorithm
        // Distinct Elements Triplets [At max 2 majority elements]
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int value1 = nums[0];
        int value2 = nums[0];
        int freq1 = 0;
        int freq2 = 0;
        for(int i = 0 ; i < n ; i++)
        {
            if(nums[i] == value1)
            freq1 += 1;
            else if(nums[i] == value2)
            freq2 += 1;
            else 
            {
                // Distinct-Element
                if(freq1 == 0)
                {
                   value1 = nums[i];
                   freq1 = 1;
                }
                else if(freq2 == 0)
                {
                   value2 = nums[i];
                   freq2 = 1;
                }
                else
                {
                    //Triplet - Formed
                    freq1--;
                    freq2--;
                }
            }
        }
        freq1 = 0;
        freq2 = 0;
        for(int i = 0 ; i < n ; i++)
        {
            if(nums[i] == value1)
            freq1 += 1;
            else if(nums[i] == value2)
            freq2 += 1;
        }
        if(freq1 > n/3)
        ans.add(value1);

        if(freq2 > n/3)
        ans.add(value2);

        return ans;
    }
}
// TC : O(2N)
// SC : O(1)
