package LinkList;

import java.util.Stack;

public class SingleLinkListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkList list = new SingleLinkList();

        // list.add(hero1);
        // list.add(hero3);
        // list.add(hero2);
        // list.add(hero4);

        list.addByOrder(hero1);
        list.addByOrder(hero3);
        list.addByOrder(hero2);
        list.addByOrder(hero4);

        // list.del(2);

        // HeroNode herotemp = new HeroNode(3, "andy", "帅哥");
        //
        // list.update(herotemp);
        // System.out.println(list.getLength());

        //System.out.println(list.findLastIndexNode(1));
        //list.reversetList();

        list.reversePrint();

    }
}


class SingleLinkList{
    private HeroNode head = new HeroNode(0,"","");

    /**
     * 逆序打印链表
     * 利用栈先进后出的特点,把链表从头到尾压栈
     * 出栈的时候就是从尾到头
     */
    public void reversePrint(){
        //空表
        if (head.next == null)
            return;

        Stack<HeroNode> stack = new Stack<HeroNode>();

        HeroNode temp = head.next;
        while (temp != null){
            stack.push(temp);
            temp = temp.next;
        }

        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }

    /**
     * 链表翻转
     */
    public void reversetList(){
        //如果链表为空或者是链表只有一个元素无需翻转
        if (head.next == null || head.next.next == null)
            return;

        HeroNode tempHead = head.next;
        HeroNode temp;
        head.next = null;

        while (tempHead != null){
            temp = tempHead.next;
            tempHead.next = head.next;
            head.next = tempHead;
            tempHead = temp;
        }


    }

    /**
     * 求出链表中倒数最后的第几个元素
     * 思路:
     * 先求出整个链表的长度length
     * 然后用length-lastindex就得到第几个倒数元素的正序值
     * 然后在遍历链表找到该元素,返回
     * @param lastIndex
     * @return
     */
    public HeroNode findLastIndexNode(int lastIndex){
        if (head.next == null)
            return null;
        int length = getLength();
        if (lastIndex < 0 || lastIndex > length)
            return null;
        HeroNode temp = head.next;
        for (int i = 0;i < length - lastIndex;i++)
            temp = temp.next;
        return temp;
    }

    /**
     * 获取头结点
     * @return
     */
    public HeroNode getHead(){
        return head;
    }

    /**
     * 返回有效节点的数量(链表的大小,不包括头结点)
     */
    public  int getLength(){

        HeroNode temp = head.next;
        int length = 0;

        while(temp != null){
            length ++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * 删除
     * @param no
     */
    public void del(int no){

        if (head.next == null){
            System.out.println("链表为空!");
            return;
        }

        HeroNode temp = head;
        boolean flag = false; //找到节点的标标志

        while (temp.next != null){
            if (temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag){
            temp.next = temp.next.next;
        }else{
            System.out.printf("没有找到编号%d的节点,不能删除\n",no);
        }

    }


    /**
     * 更新节点的数据
     * @param heroNode
     */
    public void update(HeroNode heroNode){
        //链表为空
        if (head.next == null){
            System.out.println("链表为空!");
            return;
        }

        HeroNode temp = head.next;
        boolean flag = false; //找到节点的标标志

        while (temp != null){
            if (temp.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag){
            temp.name = heroNode.name;
            temp.nickname = heroNode.nickname;
        }else{
            System.out.printf("没有找到编号%d的节点,不能修改\n",heroNode.no);
        }

    }


    /**
     * 在链表的尾部添加一个节点
     * @param heroNode
     */
    public void add(HeroNode heroNode){
        HeroNode temp = head; //temp用来遍历列表找到链表的尾部

        while(temp.next != null){
            temp = temp.next;
        }

        //在链表的尾部插入节点
        temp.next = heroNode;
    }

    /**
     * 按照排名插入hero
     * @param heroNode
     */

    public void addByOrder(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;

        while (temp.next != null){
            if(temp.next.no > heroNode.no){ //找到位置
                break;
            }else if (temp.next.no == heroNode.no){//编号已经存在
                flag = true;
                break;
            }

            temp = temp.next;
        }

        if(flag){
            System.out.printf("准备插入的英雄的编号%d已经存在,不能加入\n",heroNode.no);
        }else{//进行插入,注意,如果到达链表的尾部还没找到,就在尾部插入
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }

    /**
     * 打印链表
     */

    public void show(){
        //链表为空
        if (head.next == null){
            System.out.println("链表为空!");
            return;
        }

        HeroNode temp = head.next;

        while (temp != null){
            System.out.println(temp);
            temp = temp.next;
        }
    }
}



class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no,String name,String nickname){
        this.no = no;
        this.nickname = nickname;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname +
                '}';
    }
}