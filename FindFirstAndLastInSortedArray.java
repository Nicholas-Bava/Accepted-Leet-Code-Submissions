public class FindFirstAndLastInSortedArray {

    public int[] searchRange(int[] nums, int target) {

        if (nums.length == 0){
            return new int[]{-1,-1};
        }

        int[] targetLeft = {-1};
        int[] targetRight = {-1};

        int leftPos = binarySearchLow(nums, target, 0, nums.length -1, targetLeft);
        int rightPos = binarySearchHigh(nums, target, 0, nums.length -1, targetRight);

        return new int[]{leftPos, rightPos};

    }

    public int binarySearchLow(int[] nums, int target, int low, int high, int[] targetPosition){

        if (low > high){
            return targetPosition[0];
        }

        int mid = low + (high - low) / 2;

        if (nums[mid] == target) {
            if (mid < targetPosition[0] || targetPosition[0] == -1) {
                targetPosition[0] = mid;
            }
        }

        if (target <= nums[mid]){
            binarySearchLow(nums, target, low, mid - 1, targetPosition);
        } else if (target > nums[mid]){
            binarySearchLow(nums, target, mid + 1, high, targetPosition);
        }

        return targetPosition[0];
    }

    public int binarySearchHigh(int[] nums, int target, int low, int high, int[] targetPosition){

        if (low > high){
            return targetPosition[0];
        }

        int mid = low + (high - low) / 2;

        if (nums[mid] == target) {
            if (mid > targetPosition[0]) {
                targetPosition[0] = mid;
            }
        }

        if (target < nums[mid]){
            binarySearchHigh(nums, target, low, mid - 1, targetPosition);
        } else if (target >= nums[mid]){
            binarySearchHigh(nums, target, mid + 1, high, targetPosition);
        }

        return targetPosition[0];

    }
}
