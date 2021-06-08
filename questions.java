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
               while(fast.next!=null && fast.next.next!=null){
                   slow=slow.next;
                   fast=fast.next.next;
                }
               return slow;
           }
          //remove kth node
       
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

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if(l1==null || l2==null)
                 return l1 != null ? l1 : l2;
            ListNode dummy= new ListNode(-1);
            ListNode prev= dummy;
            ListNode c1= l1, c2=l2;
            while(c1 != null && c2 != null){
                if(c1.val<c2.val){
                    prev.next=c1;
                    c1=c1.next;
                 }else{
                    prev.next=c2;
                    c2=c2.next;
                }
                prev=prev.next;
            }
            prev.next= c1 != null ? c1 : c2;
            return dummy.next;
        }
        //mergeSort in linkedlist
        public ListNode sortList(ListNode head) {
            if(head==null || head.next==null)
                 return head;
        ListNode mid= middleNode(head);
        ListNode nhead= mid.next;
        mid.next= null;
        
        ListNode leftSortedList= sortList(head);
        ListNode rightSortedList= sortList(nhead);
        return mergeTwoLists(leftSortedList, rightSortedList);
            
        }
        //Intersection of LL
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            return findIntersection(headA, headB);
        }
        
        public int findLength(ListNode node){
            if(node==null)
                return 0;
            ListNode curr= node;
            int len= 0;
            while(curr!=null){
                curr=curr.next;
                len++;
            }
            return len;
        }
        
        public ListNode findIntersection(ListNode one, ListNode two){
            int a= findLength(one);
            int b= findLength(two);
            
            ListNode biggerNode= a > b ? one : two;
            ListNode smallerNode= b < a ? two : one;
            
            int diff= Math.abs(a-b);
            
            while(diff-->0){
                biggerNode= biggerNode.next;
            }
            
            while(biggerNode != smallerNode){
                biggerNode= biggerNode.next;
                smallerNode= smallerNode.next;
            }
            
            return smallerNode!=null ? smallerNode : null;
            
        }

        public boolean isPalindrome(ListNode head) {
            // if(head==null || head.next==null)
            //      return true;
            ListNode mid= middleNode(head);
            ListNode nhead= mid.next;
            mid.next=null;
            
            nhead=reverseList(nhead);
            ListNode c1=head, c2=nhead;
            boolean ans=true;
            while(c2!=null){
                if(c1.val != c2.val){
                    ans=false;
                    break;
                }
                c1= c1.next;
                c2= c2.next;
            }
            nhead=reverseList(nhead);
            mid.next=nhead;
            return ans;
        }
    }   
}
