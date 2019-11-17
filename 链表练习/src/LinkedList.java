class LinkedNode {
    //链表应具有2个属性即数据和指向下一个数据的索引
    public int data = 0;
    public LinkedNode next = null;
    public LinkedNode(){}
    public LinkedNode(int data){
        this.data = data;
    }
}
public class LinkedList {
    //定义一个空的引用作为头引用，来指向第一个数据
    public LinkedNode head = null;
    public LinkedNode getLinkedNode(){
        return this.head;
    }
    //链表实现头插法
    public void addFirst(int data) {
        //创建一个节点来接纳数据data
        LinkedNode node = new LinkedNode(data);
        //如果链表为空,直接将数据赋值就行
        if (head == null) {
            head = node;
        }else {//如果链表不为空，则需要将第一个索引指向新数据
            node.next = head;
            head = node;
        }
    }
    //链表实现尾插法
    public void addLast(int data) {
        //创建一个节点来接纳数据data
        LinkedNode node = new LinkedNode(data);
        //如果链表为空则直接放入
        if (head == null) {
            head = node;
            return;
        }
        LinkedNode cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }
    //任意插入一个元素
    public void addIndex(int index, int data){
        LinkedNode node = new LinkedNode(data);
        if (index == 0) {
            addFirst(data);
            return;
        }
        //写一个方法来计算链表长度
        int s = size(head);
        if (s == index) {
            addLast(data);
            return;
        }
        LinkedNode cur = head;
        for (int i=0; i<index-1; i++) {
            cur = cur.next;
        }
        node.next = cur.next;
        cur.next = node;
    }
    //查找元素是否出现在链表中
    public boolean contains(int data) {
        if (head == null) {
            return false;
        }
        LinkedNode cur = head;
        while (cur.next != null) {
            if (cur.data == data) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //删除链表中第一次出现的目的数据
    public void remove(int data) {
        if (head == null) {
            return;
        }
        if (head.data ==data) {
            head = head.next;
            return;
        }
        LinkedNode cur = head;
        while (cur.next != null) {
            //需要得到要删除元素前一个元素的next
            if (cur.next.data == data) {
                LinkedNode temp = cur.next;
                cur.next = temp.next;
                return;
            }
            cur = cur.next;
        }
    }
    //删除所有链表中的给定值
    public void removeAllData(int data) {
        if (head == null) {
            return;
        }
        LinkedNode perv = head;
        LinkedNode temp = head.next;
        while (temp != null) {
            if (temp.data == data) {
               temp = temp.next;
               perv.next = temp;
            }else {
                perv = temp;
                temp = temp.next;
            }

        }
        if (head.data == data) {
            head = head.next;
        }
    }
    //反转一个单链表
    public void offset(LinkedNode head) {
        if (head == null || head.next == null) {
            return;
        }
        LinkedNode prev = null;
        LinkedNode cur = head;
        while (cur != null) {//如果node的下一个节点不为空，继续循环
            LinkedNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            System.out.println(prev.data);
        }
        this.head = prev;
    }
    //返回链表中间节点的值
    public int midLink(LinkedNode head) {
        if (head == null) {
            return -1;
        }
        if (head.next == null) {
            return head.data;
        }
        int mid = size(head) / 2;
        LinkedNode midLink = head;
        for (int i = 0; i < mid; i++) {
            midLink = midLink.next;
        }
        return midLink.data;
    }
    //返回链表中倒数第k个值
    public int kLinkIs(LinkedNode head, int k) {
        int len = size(head) - k;
        if (head == null || len < 0 || k <= 0) {
            return -1;
        }
        LinkedNode tempNode = head;
        for (int i = 0; i < len; i++) {
            tempNode = tempNode.next;
        }
        return tempNode.data;
    }
    //合并两个有序链表
    public LinkedNode mergeTwoLists(LinkedNode l1, LinkedNode l2) {
        LinkedNode theOneList = l1;
        LinkedNode theTwoList = l2;//两个链表的节点
        LinkedNode newHead = new LinkedNode(0);
        LinkedNode newTail = newHead;
        newHead.next = newTail;
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }
        while (theOneList != null && theTwoList != null) {
            if (theOneList.data < theTwoList.data) {
                newTail.next = new LinkedNode(theOneList.data);
                theOneList = theOneList.next;
                newTail = newTail.next;
            }else {
                newTail.next = new LinkedNode(theTwoList.data);
                theTwoList = theTwoList.next;
                newTail = newTail.next;
            }
        }
        if (theOneList == null) {
            newTail.next = new LinkedNode(theTwoList.data);
        }
        if (theTwoList == null) {
            newTail.next = new LinkedNode(theOneList.data);
        }
        return newHead.next;
    }
    //删除链表中所有相同元素
    public LinkedNode deleteDuplication(LinkedNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        LinkedNode newHead = new LinkedNode(0);
        newHead.next = head;
        LinkedNode prev = newHead;
        LinkedNode cur = prev.next;
        while (cur.next != null) {
            if (cur.data == cur.next.data) {
                while (cur.next != null && cur.data == cur.next.data) {
                    cur = cur.next;
                }
                prev.next = cur.next;
                cur = cur.next;
            }else {
                prev = prev.next;
                cur = cur.next;
            }
        }
        return newHead.next;
    }
    //将链表中小于给定值的节点往前放，大于给定值的节点往后放
    public LinkedNode setLink(LinkedNode head ,int val) {
        LinkedNode newHead = head;
        LinkedNode smallHead = new LinkedNode(0);
        LinkedNode smallTail = null;
        LinkedNode bigHead = new LinkedNode(0);
        LinkedNode bigTail = null;
        while (newHead != null) {
            if (newHead.data < val) {
                if (smallTail == null) {
                    smallTail = newHead;
                    smallHead.next = smallTail;
                }else {
                    smallTail.next = newHead;
                    smallTail = smallTail.next;
                }
            }else {
                if (bigTail == null) {
                    bigTail = newHead;
                    bigHead.next = bigTail;
                }else {
                    bigTail.next = newHead;
                    bigTail = bigTail.next;
                }
            }
            newHead = newHead.next;
        }
        smallTail.next = bigHead.next;
        return smallHead.next;
    }
    //链表回文
    public boolean LinkTailAndHead(LinkedNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        LinkedNode newHead = head;
        LinkedNode fast = head;
        LinkedNode slow = head;
        LinkedNode temp = head;
        while (fast.next != null && temp.next != null) {
            fast = fast.next.next;
            temp = fast.next;
            slow = slow.next;
        }
        LinkedNode prev = null;
        while (slow.next != null) {
            LinkedNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        while (slow != null && slow.data == newHead.data) {
            slow = slow.next;
            newHead = newHead.next;
        }
        if (slow == null) {
            return true;
        }
        return false;
    }
    //求链表长度
    public int size(LinkedNode head) {
        int size = 0;
        if (head == null) {
            return size;
        }
        LinkedNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            size++;
        }
        return ++size;
    }
    //展示链表的元素
    public void disPlay(LinkedNode head) {
        LinkedNode cur = head;
        System.out.print("[");
        while (cur != null) {
            System.out.print(cur.data);
            if (cur.next != null) {
                System.out.print(", ");
            }
            cur = cur.next;
        }
        System.out.println("]");
    }
}
