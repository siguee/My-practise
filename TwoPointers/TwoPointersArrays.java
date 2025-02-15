import java.util.Arrays;

public class TwoPointersArrays {
    //把索引当作数组的双指针
    // 1.26原地修改数组
     public int removeDuplicates(int[] nums){
        if(nums.length==0) return 0;
        int slow=0,fast=0;
        while(fast<nums.length){
            if(nums[slow]!=nums[fast]){
                slow++;
                //重复略过 不重复更新
                nums[slow]=nums[fast];
            }
            fast++;
        }
        return slow+1;
     }

     // 2. 27移除元素 对元素进行原地删除
     public int removeElement(int[] nums,int val){
        int fast=0,slow=0;
        while(fast<nums.length){
            if(nums[fast]!=val){//这个程序可以保证在0-slow里都是括号里要求的元素。
                nums[slow]=nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
     }

     //3. 283移动0 输入nums原地修改所有值为0的元素移动到数组末尾
     public void moveZeros(int[] nums){
        int slow = 0;
        int fast = 0;
        while(fast<nums.length){
            if(nums[fast]!=0){
                int temp = nums[slow];
                nums[slow]=nums[fast];
                nums[fast]=temp;
                //nums[fast]=0; 需要考虑只有一个元素的特殊情况
                slow++;
            }
            fast++;
        }
     }

     //滑动窗口算法
     /*主要是为了解决子数组的问题(符合条件的子数组) */

     public static void main(String[] args) {
        
     }
}
