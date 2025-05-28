public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {

        int nodeCount = 0;

        ListNode currentNode = new ListNode();

        if (head == null){
            return null;
        }

        currentNode = head;

        if (head.next == null){
            return currentNode;
        }

        while (true){

            nodeCount++;

            if (currentNode.next == null){
                break;
            }

            currentNode = currentNode.next;
        }

        currentNode = head;
        ListNode nextNode = head.next;
        ListNode headNode = head.next;

        ListNode subsequentNode = new ListNode();
        ListNode subsequentNextNode = new ListNode();

        for (int i = 1; i < nodeCount; i+=2){

            if (currentNode.next.next != null){
                subsequentNode = currentNode.next.next;

                if (nextNode.next.next != null){
                    subsequentNextNode = nextNode.next.next;
                    currentNode.next = nextNode.next.next;
                }

                else {
                    currentNode.next = nextNode.next;
                }

            } else {
                currentNode.next = null;
            }

            nextNode.next = currentNode;

            currentNode = subsequentNode;
            nextNode = subsequentNextNode;
        }

        return headNode;
    }
}
