class Solution {
    public void findSubsetSums(int index , int[] arr , ArrayList<Integer> ans , int sum)
    {
        if(index == arr.length)
        {
            ans.add(sum);
            return;
        }
        // Take current index element into subset
        findSubsetSums(index + 1 , arr , ans , sum + arr[index]);
        
        // Not-Take current index element into subset
        findSubsetSums(index + 1 , arr , ans , sum);
        
    }
    public ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        findSubsetSums(0 , arr , ans , 0);
        return ans;
       
    }
}
