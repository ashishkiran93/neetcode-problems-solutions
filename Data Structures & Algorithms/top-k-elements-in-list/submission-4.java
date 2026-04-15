class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((e1,e2)->e2.getValue()-e1.getValue());
        for(int num:nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }
            else{
                map.put(num,1);
            }
        }

        map.entrySet().stream().forEach(e->pq.offer(e));
        
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<k;i++){
            set.add(pq.poll().getKey());
        }

        return set.stream().sorted().mapToInt(Integer::intValue).toArray();

    }
}
