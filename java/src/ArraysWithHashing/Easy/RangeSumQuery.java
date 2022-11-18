package ArraysWithHashing.Easy;

/*
    303. Range Sum Query - Immutable (prefix version)
 */
public class RangeSumQuery {
        int[] nums;

        public void NumArray(int[] nums) {
            this.nums = new int[nums.length];
            int total =0;
            for ( int i =0; i< nums.length;i++){
                total += nums[i];
                this.nums[i]=total;
            }
        }

        public int sumRange(int left, int right) {
            int preRight = this.nums[right];
            int preLeft = left > 0 ? this.nums[left-1] : 0;
            return (preRight - preLeft);
        }
}
/*
 // Non-prefix version
class NumArray {
    int[] nums;

    public NumArray(int[] nums) {
        this.nums=nums;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for(int i=left;i<=right;i++){
           sum+= this.nums[i];
        }
        return sum;
    }
}
 */
