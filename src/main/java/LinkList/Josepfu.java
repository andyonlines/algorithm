package LinkList;

/**
 * 该程序是用单向循环链表解决约瑟夫问题
 * Josephu  问题为：设编号为1，2，… n的n个人围坐一圈，
 * 约定编号为k（1<=k<=n）的人从1开始报数，数到m 的那个人出列，
 * 它的下一位又从1开始报数，数到m的那个人又出列，依次类推，
 * 直到所有人出列为止，由此产生一个出队编号的序列。
 */
public class Josepfu {
    public static void main(String[] args) {
        jesepfuFunc(5,2,1);
    }

    /**
     *
     * @param num 链表节点的数量
     * @param start 从哪个位置开始
     * @param range 隔几个节点抽一个
     */
    public static void jesepfuFunc(int num, int start,int range){
        CircleSingleLinkedList list = new CircleSingleLinkedList();
        list.addNode(num);
        list.show();
        list.setFirst(start);


        Node node = null;

        System.out.println("退出的编号为: ");
        //开始抽取数据,直到链表为空为止
        while (!list.isEmpty()){
            node = list.del(range);
            System.out.print(node.getNo() + " ");
        }
        System.out.println();
    }
}

class CircleSingleLinkedList {

    private Node first = null;

    /**
     * 判断数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return first == null;
    }

    /**
     * 设置first 的位置
     * @param index
     */
    public void setFirst(int index){
        if(index < 0 || index > getCount() || index == 1){
            return ;
        }

        for (int i = 1; i < index; i++) {
            first = first.getNext();
        }
    }

    /**
     * 增加num个node
     * 编号从1 到 num
     *
     * @param num
     */
    public void addNode(int num) {
        if (num < 1) {
            System.out.println("num 的值不正确");
            return;
        }

        Node temp = null;

        for (int i = 1;i <= num;i++){
            Node node = new Node(i);


            if (i == 1){ //处理第一个节点
                first = node;
                node.setNext(node); //节点自己指向自己
                temp = node;
            }else{
                /**
                 * node节点的下一个节点指向first,因为插入之后node节点讲师最后的
                 * 原来链表的next指向node
                 * temp指向node
                 */
                node.setNext(first);
                temp.setNext(node);
                temp = node;
            }
        }
    }

    /**
     * 求链表节点的数量
     * @return
     */
    public int getCount(){
        if (first == null){
            return 0;
        }
        Node temp = first;

        int count= 0;
        while (true){
            count++;
            if (temp.getNext() == first){
                break;
            }
            temp = temp.getNext();
        }
        return count;
    }

    /**
     *
     * 返回链表的尾结点
     * @return
     */
    public Node getTail(){
        if (first == null){
            System.out.println("没有数据");
            return null;
        }
        Node temp = first;

        while (true){
            if (temp.getNext() == first){
                break;
            }
            temp = temp.getNext();
        }
        return temp;
    }

    /**
     * 删除指定位置的节点,并返回
     * @param index
     * @return
     */
    public Node del(int index){
        if(index < 1 || getCount() == 0){
            System.out.println("index 的值不正确");
            return null;
        }
        boolean flat = false;

        //只有
        if (getCount() == 1)
            flat = true;

        Node temp = first;
        if (index == 1){ //删除第一个节点的情况
            Node tail = getTail();
            first = temp.getNext();
            tail.setNext(first);

        }else {//其它情况
            for (int i = 1; i < index; i++) {
                first = temp;
                temp = temp.getNext();
            }
            first.setNext(temp.getNext());
            first = first.getNext();
        }

        //当链表只有一个节点的情况,需要把frist指向null
        if (flat)
            first = null;
        return temp;
    }

    /**
     * 显示链表
     */
    public void show(){
        if (first == null){
            System.out.println("没有数据");
            return;
        }
        Node temp = first;

        System.out.print("[ ");
        while (true){
            System.out.printf("%d ",temp.getNo());
            if (temp.getNext() == first){
                break;
            }
            temp = temp.getNext();
        }
        System.out.println(" ]");
    }

}

 class Node {
    private int no;//人的编号
    private Node next; //指向下一个节点

    public Node(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}