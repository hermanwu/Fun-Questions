/**
 * Created by Herman on 9/27/2015.
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while(i > 0){
            if(nums[i-1] < nums[i]) {
                break;
            }
            i--;
        }
        if(i > 0) {
            i--;
            int j = nums.length - 1;
            while(j > i) {
                if(nums[j] > nums[i]) {
                    swap(nums, i, j);
                    break;
                }
                j--;
            }
            sort(nums, i+1, nums.length-1);
        } else {
            sort(nums, 0, nums.length-1);
        }
        return;
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void sort(int[] nums, int start, int end) {
        if(start >= end){
            return;
        }
        int pivot = nums[start];
        int i = start+1;
        int j = start+1;
        while(j<=end) {
            if(nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
            j++;
        }
        swap(nums, start, i-1);
        sort(nums, start, i-2);
        sort(nums, i, end);
        return;
    }

    public static void main(String[] args) {
        NextPermutation test = new NextPermutation();
        int[] input = new int[]{1};
        test.sort(input, 0, input.length-1);
    }
}
