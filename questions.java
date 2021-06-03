public class questions {
    //mid
    public class ListNode {
            int val;
            ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
       class Solution {
           public ListNode middleNode(ListNode head) {
               if(head==null || head.next==null)
                    return head;
               ListNode slow=head;
               ListNode fast=head;
               while(fast!=null && fast.next!=null){
                   slow=slow.next;
                   fast=fast.next.next;
                }
               return slow;
           }
       }    //remove kth node
       
           public ListNode removeNthFromEnd(ListNode head, int n) {
               if(head==null || head.next==null)
                     return null;
               ListNode slow=head;
               ListNode fast=head;
               while(n-->0){
                   fast=fast.next;
               }
               if(fast==null)
                    return head.next;
               while(fast!=null && fast.next!=null){
                    slow=slow.next;
                    fast=fast.next;
                 }
               ListNode node= slow.next;
               slow.next=slow.next.next;
               node.next=null;
               return head;
               
           }
           //83
           public ListNode deleteDuplicates(ListNode head) {
            if(head==null || head.next==null)
                  return head;
            ListNode dummy= new ListNode(-1);
            ListNode dp=dummy;
            dp.next=head;
            dp=dp.next;
            ListNode curr= head.next;
            int size=0;
            while(curr!=null){
                while(curr!=null && curr.val==dp.val){
                    ListNode forw= curr.next;
                    curr.next=null;
                    curr=forw;
                }
                dp.next=curr;
                if(curr!=null){
                    curr=curr.next;
                    dp=dp.next;
                    size++;
                }
            }
            return dummy.next;
        }
        //reverse ll
        public static ListNode reverseList(ListNode head) {
            if(head==null || head.next==null){
                return head;
            }
            ListNode prev=null;
            ListNode curr=head;
            while(curr!=null){
                ListNode forw=curr.next;
                curr.next=prev;
                prev=curr;
                curr=forw;
            }
            return prev;
        }
       
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2 ){
          l1=reverseList(l1);
          l2=reverseList(l2);
          ListNode dummy= new ListNode(-1);
          ListNode prev=dummy;
          ListNode c1=l1,c2=l2;
          int carry=0;
          while(c1!=null || c2!=null || carry!=0){
              int sum= carry+(c1!=null ? c1.val : 0)+(c2!=null ? c2.val : 0);
              carry=sum/10;
              sum%=10;
              prev.next=new ListNode(sum);
              prev=prev.next;
              if(c1!=null)c1=c1.next;
              if(c2!=null)c2=c2.next;
          }
          ListNode head= dummy.next;
          head=reverseList(head);
          l1=reverseList(l1);
          l2=reverseList(l2);
          return head;
        }

       
}
