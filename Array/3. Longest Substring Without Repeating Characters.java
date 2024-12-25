class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
        return 0;
        Map<Character , Integer> map = new HashMap<>();
        int LongestSubstringLength = 0;
        int start = 0;
        int end = 0;
        while(end < s.length())
        {
            char ch = s.charAt(end);
            if(map.containsKey(ch))
            {
               int index = map.get(ch); 
              
               if(start <= index)// check if is in range.
               {
                LongestSubstringLength = Math.max(LongestSubstringLength , end - start);
                start = index + 1 ;
               }
            }
            map.put(ch , end);
            end += 1;
        } 
        LongestSubstringLength = Math.max(LongestSubstringLength , end - start);
        return LongestSubstringLength;
        
    }
}
// TC : O(N)
// SC : O(N)[Map]
