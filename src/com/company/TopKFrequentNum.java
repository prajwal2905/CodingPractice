public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int[] result = new int[k];
        for(int num:nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for(Map.Entry<Integer, Integer> val : freq.entrySet()) {
            pq.add(val);
            if(pq.size() > k) pq.poll();
        }

        int i = k-1;

        while(!pq.isEmpty()) 
            result[i--] = pq.poll().getKey();
        
        return result;
    }
