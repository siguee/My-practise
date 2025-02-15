import java.util.List;
import java.util.PriorityQueue;

public class TwoPointersListNode {
    // 单链表的大多数指针都属于快慢指针
    class ListNode{
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode mergeTwoSortedLists(ListNode l1,ListNode l2){
        //创建一个head为dummy并且有指向它的指针p的链表存储答案
        /*虚拟头节点 当创造一条新的链表的时候，使用其简化边界情况的处理 */
        ListNode dummy = new ListNode(-1),p=dummy;
        ListNode p1 = l1,p2=l2;
        while(p1!=null&&p2!=null){
            if(p1.val>p2.val){
                //为什么这里不需要像树一样把p2.next.val存在dummy里呢
                /*
                 链表是一种线性的数据结构，每个节点包含数据和指向下一个节点的引用
                 在合并两个有序链表时，只需要改变节点之间的引用关系，就能将两个链表合成一个新的有序链表
                 */
                p.next = p2;
                p2=p2.next;
            }else{
                p.next = p1;
                p1=p1.next;
            }
            p=p.next;
        }
        if(p1!=null){
            p.next = p1;
        }
        if(p2!=null){
            p.next = p2;
        }
        return dummy.next;

    }
    public ListNode partition(ListNode l,int x){
        ListNode dummy1 = new ListNode(-1),p1=dummy1;
        ListNode dummy2 = new ListNode(-1),p2=dummy2;
        ListNode p=l;
        while(p!=null){
            if(p.val<x){
                p1.next = p;
                p1 = p1.next;
            }else{
                p2.next = p;
                p2 = p2.next;
            }
            //p=p.next; 错误的写法 不能直接让p前进，而是要先断开原结点的next指针
            ListNode temp = p.next;
            p.next=null;
            p=temp;
        }
        p1.next=dummy2.next;
        return dummy1.next;
    }

    //给你一个链表数组，每个链表都已经按升序排列。请你将所有链表合并到一个升序链表中，返回合并后的链表。

    public ListNode mergeKLists(ListNode[] Lists){
        if(Lists.length==0){return null;}
        ListNode dummy = new ListNode(-1),p=dummy;
        //逻辑类似于合并两个有序链表，但是如何快速找到k个结点的最小节点？：队列
        /*优先队列：创建优先队列时，默认是最小堆，即优先级低的元素先出队（小） */
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            Lists.length,(a,b)->(a.val-b.val));
            //当a.val-b.val＜0时，按照ab的顺序排入队列
        for(ListNode head:Lists){
            if(head!=null){
                pq.add(head);
            }
        }
        while(!pq.isEmpty()){
            // 在队列里取值
            ListNode node = pq.poll();
            p.next = node;
            if(node.next!=null){
                pq.add(node.next);
            }
            p=p.next;
        }
        
        return dummy.next;
        /* */
    }

    //单链表的倒数第K个节点。在只给出head、只遍历一次的情况下找出。（从0开始）
    /*倒数第k个节点是正数n-k+1个节点，要走n-k步 */
    public ListNode findFromEnd(ListNode l,int k){
        ListNode p1=l,p2=l;
        for(int i=0;i<k;i++){
            p1=p1.next;
        }
        while(p1!=null){
            p1=p1.next;
            p2=p2.next;
        }
        return p2;
    }

    //一次遍历找中点 快慢指针 如果链表长度为偶数返回的是靠后的那个节点
    //判断链表是否包含环 若fast和slow相遇则代表有环
    public ListNode midlleNode(ListNode l){
        ListNode s=l,f=l;
        while(f!=null&&f.next!=null){
            f=f.next.next;
            s=s.next;
            /*
             if(s==f){
             return true}
             方法要改为boolen
             */
        }
        return s;
    }

    //计算环起点
    public ListNode detectCycle(ListNode l){
        ListNode fast=l,slow=l;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast==slow) {
                break;
            }
        }
        if(fast==null||slow==null){
            return null;
        }
        fast = l;
        while(fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }

    //两个链表是否相交
    //若两链表相交，路径相同时，会同时到达交点
    public ListNode getIntersectionNode(ListNode headA,ListNode headB){
        ListNode p1=headA,p2=headB;
        while(p1!=p2){
            if(p1==null){
                p1.next=headB;
            }else{
                p1=p1.next;
            }
            if(p2==null){
                p2.next=headA;
            }else{
                p2=p2.next;
            }
        }
        return p1;
    }



    


    public static void main(String[] args) {
        
    }
}
