import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwopointersListNode2 {
    //labuladong和代码随想录综合下的一些链表双指针习题
    class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
        }
    }
    //206反转链表
    public ListNode reverseList(ListNode l){
        ListNode pre,cur,tmp;
        pre = null;cur=l;tmp=null;
        while(cur!=null){
            tmp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=tmp;
        }
        return pre;

    }
    //三数之和等于0(数组双指针)
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) return result;
            if(nums[i]==nums[i-1]&&i>0){
                continue;
            }
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum<0){
                    left++;
                }else if(sum>0){
                    right--;
                }else{
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    if (right>left&&nums[right]==nums[right-1]) {
                        right--;
                    }
                    if (right>left&&nums[left+1]==nums[left]) {
                        left++;
                    }
                    left++;
                    right--;
                }
            }

        }
        return result;

    }
    //83删除排序链表中的重复元素
    public ListNode deleteDuplicates(ListNode head){
        if(head==null) return head;
        ListNode slow = head,fast=head;
        while(fast.next!=null){
            if(fast.val!=slow.val){
                //在一个数组更新元素和在一条链表中更新元素的方法是不一样的
                slow.next=fast;
                slow = slow.next;
                //slow.val=fast.val;
            }
            fast = fast.next;
        }
        // 如何返回从0到slow的链表
        slow.next=null;
        return head;
    }
    //判断回文链表

    public static void main(String[] args) {
        
    }
}
