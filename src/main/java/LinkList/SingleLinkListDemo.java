package LinkList;

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

        list.del(2);

        // HeroNode herotemp = new HeroNode(3, "andy", "帅哥");
        //
        // list.update(herotemp);

        list.show();

    }
}


class SingleLinkList{
    private HeroNode head = new HeroNode(0,"","");

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