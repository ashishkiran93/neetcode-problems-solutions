class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        int count=0;
        int left=0,right=0;
        int minLength = Integer.MAX_VALUE;
        int minLeft =0;
        for(char c :t.toCharArray()){
           map.put(c,map.getOrDefault(c,0)+1);
        }
        map.forEach((k,v)->System.out.println(k+":"+v));
        System.out.println("-----Initialisation--------") ;
        while(right<s.length()){
            char rightChar = s.charAt(right);
            if(map.containsKey(rightChar)){
                map.put(rightChar,map.get(rightChar)-1);
                if(map.get(rightChar)>=0){
                    count++;
                }

                while(count==t.length()){  
                
                  if(right-left+1<minLength){
                    minLength = right-left+1;
                    minLeft = left;
                  }

                  char leftChar = s.charAt(left);  
                  if(map.containsKey(leftChar)){
                    map.put(leftChar,map.get(leftChar)+1);
                    if(map.get(leftChar)>0){
                        count--;
                    }
                  }
                  left++;
                }
            }
            right++;          
        }
        
        return minLength==Integer.MAX_VALUE?"":s.substring(minLeft,minLeft+minLength);
    }
}
