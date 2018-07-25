package day07;

/**
 * Created by chen on 2018/7/25.
 */
//链式队列，由队头和队尾节点组成，节点中包含数据域和指针域
public class LinkedQueue<E> {
    //1.定义队列结构
    //节点类
    @SuppressWarnings("hiding")
    private class Node<E>{
        public E  data=null;//数据域
        public Node<E> next=null;

        public Node(){}

        public Node(E data,Node<E> next){
            this.data = data;
            this.next = next;
        }
    }/*Node*/
    private Node<E> front = null; //队头
    private Node<E> rear  = null; //队尾
    private int size = 0;         //队列长度

    //2.判断队列是否为空
    public boolean  isEmpty(){
        return size ==0;
    }
    //3.入队
    public boolean push(E e) {
        Node<E> node = new Node<E>(e, null);
        if (isEmpty()) {
            rear = node;
            front = rear;
            size++;
            return true;
        }
        rear.next = node;
        rear = node;
        size++;
        return true;
    }
    //4.出队
    public E pop() {
        //判断队列是否为空
        if (isEmpty()) {
            System.err.println("队列为空");
            return null;
        }
        //返回头结点
        Node<E> e = this.front;
        //头结点指向下一个节点
        front=front.next;
        e.next = null; //释放原队头节点引用
        size--;
        return e.data;
    }
    //5.返回队头但不删除
    public E peek(){
        //判断是否为空
        if(isEmpty()){
            System.err.println("为空，不能返回");
            return null;
        }
    return front.data;
    }
    //6.求长
    public int getSize(){
        return this.size;
    }

    //7.打印队列
    public void display(){
        while(front != null){
            System.out.println(front.data);
            front=front.next;
        }
    }

    public static void main(String args[]){
        LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
        //1.入队
        int i = 0;
        while(i < 10){
            queue.push(i);
            i++;
        }

//        //出队
//        int j = 0;
//        while(j < 8){
//            System.out.println(queue.pop());
//            j ++;
//        }


       queue.display();

    }

}
