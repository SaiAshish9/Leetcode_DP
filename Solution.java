package org.dp;

class Solution {

//int calc(Node *list) {
//    if (list == nullptr) return 1;
//    int newCarry = calc(list->next);
//    int dig = list->digit + newCarry;
//    list->digit = dig % 10;
//    return dig/10;
//}

//void addOne(List* list) {
//    //first add 1 to the last node and propagate the carry to recursion calls
//    int carry = calc(list->first);
//    if (carry) {
//        Node *t = new Node(carry, list->first);
//        list->first = t;
//    }
//}

//int main() {
//    Node* node1 = new Node(9, NULL);
//    Node* node2 = new Node(9, node1);
//    Node* node3 = new Node(9, node2);
//    Node* node4 = new Node(9, node3);
//    List* list = new List(node4);
//    printList(list); // 7 8 9 9
//    addOne(list);
//    printList(list); // 7 9 0 0
//}

    private static int calc(ListNode node) {
        if (node == null) return 1;
        int carry = calc(node.next);
        int dig = node.data + carry;
        node.data = dig % 10;
        return dig / 10;
    }

    private static void addOneViaCarry(ListNode listNode){
        int carry = calc(listNode);
        if(carry != 0){
            ListNode temp = new ListNode(carry, listNode);
            listNode = temp;
        }
        System.out.println(listNode);
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        addOneViaCarry(l1);
    }

}
