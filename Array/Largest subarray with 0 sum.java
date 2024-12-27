class Solution {
    int maxLen(int arr[]) {
       Map<Integer , Integer> map = new HashMap<>();
       map.put(0 , -1);
       int sum = 0 , subarrayLength = 0;
       for(int i = 0 ; i < arr.length ; i++)
       {
           sum += arr[i];
           if(map.containsKey(sum))
           subarrayLength = Math.max(subarrayLength , i - map.get(sum));
           else
           map.put(sum , i); 
       }
       return subarrayLength;
    }
}
// TC : O(N)
// SC : O(N)[Map]
