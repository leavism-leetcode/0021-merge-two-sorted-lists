public class Solution {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(-1);
        ListNode currentNode = result;

        while (list1 != null || list2 != null) {
            boolean list1Exist = list1 != null && list2 == null;
            boolean list2Exist = list1 == null && list2 != null;

            if (list1Exist) {
                ListNode node = new ListNode(list1.val);
                currentNode.next = node;
                currentNode = currentNode.next;
                list1 = list1.next;
                continue;
            } else if (list2Exist) {
                ListNode node = new ListNode(list2.val);
                currentNode.next = node;
                currentNode = currentNode.next;
                list2 = list2.next;
                continue;
            }

            if (list1.val <= list2.val) {
                ListNode node = new ListNode(list1.val);
                currentNode.next = node;
                currentNode = currentNode.next;
                list1 = list1.next;
            } else {
                ListNode node = new ListNode(list2.val);
                currentNode.next = node;
                currentNode = currentNode.next;
                list2 = list2.next;
            }
        }
        return result.next;
    }
    /*
    This is exactly like mergeSort(), but just the merge() function
    because the list is already sorted
    */
    public static ListNode recursiveMergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if(list1.val < list2.val) {
            list1.next = recursiveMergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = recursiveMergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        ListNode i3 = new ListNode(4);
        ListNode i2 = new ListNode(3, i3);
        ListNode i1 = new ListNode(1, i2);

        ListNode l3 = new ListNode(4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);

        ListNode p1 = recursiveMergeTwoLists(l1, i1);
        while(p1 != null) {
            System.out.println(p1.val);
            p1 = p1.next;
        }
    }
}