package day05;

/**
 * Created by chen on 2018/7/23.
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 1.链表是多个不连续的地址组成在一起根据指针链接在一起的，由多个节点组成，每个节点包括元素域和指针域
 * 2.元素域存储节点数组，指针域存储下一节点指针
 * 3.我们对链表的操作都是间接的通过链表头节点操作来实现的
 * 4.一个链表中有多个节点，一个节点包括元素域，和下一节点指针域
 * 5.最左边的节点是头节点，但是添加节点是从右到左添加，新添加的节点会被作为头节点
 * 6.链表是由不定数量的节点连接（通过相互之间的引用）起来的，由于这种关系，在链表里我们只定义了头节点和节点数量。节点是由存储的对象及对下一个“节点”的引用封装而成。
 * 7.在添加节点到链表中时，首先添加的节点后置后，新添加的节点作为头节点引用前一个添加的节点。
 * @author LH-PC
 *
 */
public class LinkedList<E> implements Serializable{
    private static final long serialVersionUID = 1L;
    private Node<E> head; //头节点
    private int size;     //节点数量，即链表长度
    //添加头节点 在添加链表节点时，首先添加的节点(头节点)后置，新添加的节点变成头节点，并且执向前一个头节点
    public void addNode(E e){
        //如果有头节点，则添加新的节点为头节点，新的头节点指向上一个头节点
        if (head!=null){
            System.out.println("链表中已经存在头节点, 正在添加新的头节点:" + e);
            System.out.println("添加成功! 此头节点指向->" + head.data);
            this.head=new Node<E>(e,head);
            size++;
        }else {
            this.head=new Node<E>(e,null);
            size++;
        }
    }
    //在指定位置插入节点
    public int insert(int index, E e){
        Node<E> temp=this.head;
        int i=0;
        if(index <i || i>this.size){
            System.err.println("索引大于链表长度或者小于0:" + index);
            return -1;
        }
        if (index == 0){
            //将头节点指向新节点,将新节点指向原来头节点的下一个节点
            this.head=new Node<E>(e,head.next);
            size++;
            return 1;
        }
        //遍历列表
        while (temp != null){
            if (index ==i){
                //将插入进来的指针域指向当前节点,将当前节点的上一个节点指针域指向当前节点
                temp.next = new Node<E>(e, temp.getNext());
                size ++; //节点长度加1
                break;
            }
            temp=head.getNext();//相下一个节点运动
            i++;
        }
        return 1;
    }
//删除头结点
    public void deleteByHead(){
        //1.找到头节点。this.head
        //2.更新头节点。将当前链表头节点设置为删除头节点的指针域
        //3.链表节点数量-1
        System.out.println("正在删除头节点:" + this.head.getData());
        this.head = this.head.next; //更新头节点为下一节点
        size --; //节点数量-1
        System.out.println("删除成功");
    }
    //删除指定位置的节点
    public void deleteByIndex(int index){
        //找到指定位置的前一个节点，将前一个节点指向后面两个节点。中间的节点就将被删除了。
        Node<E> temp = this.head;
        int i = 0;
        if(index < i || index > this.size){
            System.err.println("索引不能小于0或大于链表长度:" + index);
            return;
        }
        //如果索引为0，表示删除头节点
        if( index == 0){
            this.deleteByHead(); //调用删除头节点方法
            return;
        }
        //遍历链表
        while(temp != null){
            if(index-1 == i){
                temp.next=temp.next.next;
            }
            temp = temp.next; //继续遍历
            i ++;
        }
    }

    //更新指定位置的节点
    public void updateByIndex(int index, E e){
        if(index < 0 || index > this.size){
            System.err.println("索引小于0或者大于链表长度:" + index);
        }

//        if(index == 0){
//            this.updateByHead(e); //如果index==0,更新头节点
//        }

        //遍历链表
        int i = 0;
        Node<E> temp = this.head;
        while(temp != null){
            if(index == i){
                temp.data = e;
                break;
            }
            temp = temp.next;
            i ++;
        }

    }

    //更新头节点
    public void updateByHead(E e){
        this.head.data = e; //为头节点重新赋值
    }

    //打印链表中的所有数据 从头节点一直到尾节点。 (1).head  (2).head.next (3).head.next.next (n).head.next.n.n
    public void display(){
        Node<E> temp=this.head;
        while (temp != null){
            System.out.println(temp.getData());
            temp = temp.next;  //指向下一节点。
        }
    }
    //返回链表list
    public List<Node<E>> findAll(){
        List<Node<E>> list = new ArrayList<Node<E>>();
        Node<E> temp = this.head;
        while (temp != null){
            list.add(temp);
            temp=temp.getNext();
        }
        return list;
    }
    //查找指定位置结点
    public Node<E> findByIndex(int index) {
        Node<E> temp = this.head;
        int i = 0;
        //参数校验，返回null
        if(index < i || index > this.size){
            System.err.println("参数大于链表长度或者小于0:" + index);
            return null;
        }
        //如果index == 0,返回头节点
        if(index == 0){
            return this.head;  //如果下标为1，直接返回头节点
        }
        //遍历链表进行匹配
        while(temp != null){
            if(index==i){
                return temp;
            }
            temp = temp.next; //继续遍历
            i ++;
        }
        return null;
    }
    //获得链表节点数量
    public int getSize(){
        return this.size;
    }

    //获取当前头节点
    public Node<E> getHead(){
        return this.head;
    }

    //测试我的链表
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        //添加节点
        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(3);
        linkedList.addNode(4);
        linkedList.addNode(5);
        linkedList.addNode(6);

        linkedList.insert(6, 9);
        linkedList.updateByIndex(6, 9);
        linkedList.display();

    }
}
