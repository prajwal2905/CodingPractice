public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k <= 0) {
            return result;
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));

        for(int num1:nums1) {
            for(int num2:nums2) {
                minHeap.add(new int[]{num1+num2, num1, num2});
            }
        }
        //[[3,1,2]]
        while(k>0 && !minHeap.isEmpty()) {
            int[] element = minHeap.poll();
            List<Integer> elements = new ArrayList<>();
            elements.add(element[1]);
            elements.add(element[2]);
            result.add(elements);
            k--;
        }
        return result;
    }
