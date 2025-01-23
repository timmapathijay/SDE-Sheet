class Solution {
    public void findAllComb(int index , int[] candidates , int target , List<List<Integer>> ans , List<Integer> comb)
    {
       if(index == candidates.length)
       {
          if(target == 0)
          ans.add(new ArrayList<>(comb));

          return;
       }
       
       if(candidates[index] <= target)
       {
          comb.add(candidates[index]);
          findAllComb(index , candidates , target - candidates[index] , ans , comb);
          comb.remove(comb.size() - 1);
       }

       findAllComb(index + 1 , candidates , target , ans , comb);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findAllComb( 0 , candidates , target , ans , new ArrayList<>());
        return ans;
    }
}
