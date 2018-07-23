package day05;

/**
 * Created by chen on 2018/7/23.
 */
//节点类
public class Node<E> {
   protected Object data=null;//数据域
   protected Node<E> next =null;//指针域
    //初始化数据域
    public Node(Object data, Node<E> next) {
        this.data = data;//初始化数据域
        this.next = next;//初始化指针域
    }
    //显示节点，获取当前实体对象,数据域
    public Object getData(){
        return this.data;
    }
    //获取下一个节点
    public Node<E> getNext(){
        return this.next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
