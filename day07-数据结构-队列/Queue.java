package day07;

/**
 * Created by chen on 2018/7/25.
 */
public class Queue<E> {
    private Object[] data=null;//数据域
    private int froent =0;  //队头，允许删除
    private int rear  =0;  //队尾，允许删除
    private int maxSize =0;  //队列容量

    public Queue(){
        this(10);
    }

    public Queue(int initialSize){
        if(initialSize >=0){
            this.data=new Object[initialSize]; //初始化数据域
            this.maxSize=initialSize;
        }else {
            throw new RuntimeException("初始化大小不能小于0:" + initialSize);
        }
    }
    //判断队列是否为空
    public boolean isEmpty(){
            return this.froent == this.rear;
    }
    //判断队列是否已满
    public boolean isMaxSize(){
        return this.rear == maxSize ?true:false;//如果队尾指针大于最大容量，说明队列已经满了
    }
    //入队，从队尾插入，从队头删除
    public boolean  push(E e){
        //判断队列是否已满
        if(isMaxSize()){
            System.err.println("队列已满，无法插入");
            return false;
        }
        data[rear]=e;
        rear++;
        return true;
    }
    @SuppressWarnings("unchecked")
    public E pop() {
        //判断是否为空，为空将无法出队
        if(isEmpty()){
            System.err.println("队列为空，无法插入");
            return null;
        }
        //在队头弹出
        E e=(E)data[froent];
        data[froent] =null;
        froent++;
        return e;
    }

    //返回队首元素，但不删除
    @SuppressWarnings("unchecked")
    public E peek() {
        if (isEmpty()) {
            System.err.println("队列为空");
            return null;
        }
        E e = (E) data[froent];
        return e;
    }

    //遍历队列
    public void display(){
        while (rear >froent){
            System.out.println(data[froent]);
            froent++;
        }
    }

    //返回队列实际长度
    public int getSize() {
        return this.data.length;
    }
    public static void main(String args[]){
        Queue<Integer> queue = new Queue<Integer>();
        int i = 0;
        while(i < 10){
            queue.push(i);
            i ++;
        }
//        queue.pop();
        queue.display();
    }
}
