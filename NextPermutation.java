class NextPermutation {
    public void nextPermutation(int[] nums) {
        int pivot = -1;
        int temp = 0;
        boolean swap = false;
        for (int i = nums.length-1; i > 0; i--) {
            if (nums[i]>nums[i-1]) {
                pivot = i-1;
                break;
            }
        }
        if (pivot != -1) {
            int succ = nums.length-1;
            for (int i = nums.length-1; i > pivot; i--) {
                if ((nums[i] > nums[pivot] && nums[succ] > nums[i]) || (nums[succ] <= nums[pivot])) {
                    succ = i;
                }
            }
            temp = nums[succ];
            nums[succ] = nums[pivot];
            nums[pivot] = temp;
        }
        else {
            pivot = -1;
        }
        for (int i = pivot+1; i < ((nums.length-pivot+1)/2)+(pivot); i++) {
            temp = nums[i];
            nums[i] = nums[nums.length-1-i+pivot+1];
            nums[nums.length-1-i+pivot+1] = temp;
        }
    }
}
