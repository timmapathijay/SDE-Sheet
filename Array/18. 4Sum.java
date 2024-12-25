class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums); // n * log(n)
        // [-2 , - 1 , 0 , 0 , 1 , 2]
        for(int i = 0 ; i < n - 3 ; i++)
        {
            for(int j = i + 1 ; j < n - 2 ; j++)
            {
                int start = j + 1;
                int end = n - 1;
                while(start < end)
                {
                    long sum = (long)nums[i] + nums[j] + nums[start] + nums[end];
                    if(sum == target)
                    {
                        List<Integer> quad = new ArrayList<>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[start]);
                        quad.add(nums[end]);
                        ans.add(quad);
                        start += 1;
                        end -= 1;
                        // To avoid duplicate quadruplets
                        while(start < end && nums[start] == nums[start - 1])
                        start ++;

                        while(start < end && nums[end] == nums[end + 1])
                        end --;

                    }
                    else if(sum < target)
                    start++;
                    else
                    end--;

                }
                // To avoid duplicate quadruplets
                while(j < n - 2 && nums[j] == nums[j + 1])
                j++;
            }
            // To avoid duplicate quadruplets
            while(i < n - 3 && nums[i] == nums[i + 1])
            i++;
        }
        return ans;
    }
}
// TC : n * log (n) [Sorting] + n^3 [To find quadruplets] => O(n^3)
// SC : O(1)
