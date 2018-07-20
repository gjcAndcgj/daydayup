package day04;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by chen on 2018/7/20.
 */
public class ArrayList<E> {
    private Object[] data=null;//保存线性表的数据域
    private int length;//线性表的容量
    private int current;//实际表长
    /**
     * 默认大小设置为10
     */
    public ArrayList(){
        this(10);
    }
    /**
     * 构造方法初始化项目
     */
    public ArrayList(int initialSize){
        if (initialSize >=0){
            this.length=initialSize;
            this.data= new Object[initialSize];
            this.current=0;//初始下标设置为0
        }else {
            throw new RuntimeException("初始化大小不能小于0:" + initialSize); //异常提示
        }
    }

    /**
     * 判断表容量是否超出预定大小，如果超出将自动扩充容量
     */
    public void ensureCapacity() {
        //判断表实际长度是否超出表最大容量
        if (current >= length) {
            length *= 2; //将表最大容量*2
            data = Arrays.copyOf(data, length);  //将原数组进行拷贝
        }

    }

    /**
     * 增加方法，添加之前判断线性表是否已满
     */
    public boolean add(E e){
      //判断已满
        ensureCapacity();
      //将元素添加到数组末端
        this.data[current++]=e;
       // ++current; //下标++
        return true;
    }
    /**
     * 删除制定位置的元素
     */
    public boolean removeToIndex(int index){
        //删除数组的元素：使用改变数组下标的方式达到删除的效果。
        //遍历数组匹配指定下标，让指定下标右边的元素往左移动改变下标。最后再将最右边的下标删除
        //a b c
        //0 1 2
        //data[index] = data[index + 1];  //改变右边下标
        //data                             //删除最右边的下标
        //从待删除下标处开始遍历，将右边的元素往左移
        if(index>current){
            System.err.print(new Date() + ": 下标超出表长");
            return false;
        }
        for (int i=index;i<current-1;i++){
              this.data[i]=this.data[i+1];
        }
        this.data[current-1]=null;
        --current;
        return true;
    }
    /**
     * 增加位置的元素
     */
    public boolean addToIndex(int index,E value){
        //判断是否需要扩容
        ensureCapacity();
        //循环遍历比index大的元素，往右移位
        for (int i=current;i>index;i--){
            this.data[i]=this.data[i-1];
        }
        //在该位置插入元素
        this.data[index]=value;
        current++;
        return true;
    }
    /**
     * 根据元素下标获取值
     */
    public E get(int index) {
        if (index>this.current){
            throw new RuntimeException("下标不能小于当前数组长度:" + index);
        }
        if (index >= 0) {
            return (E) data[index];
        } else {
            throw new RuntimeException("下标不能小于0:" + index);
        }
    }

    /**
     * 返回顺序表实际表长
     *
     * @return
     */
    public int size() {
        return this.current;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>(); //创建arrayList
        for (int i = 1; i <= 22; i++) {
            list.add(i);
        }
        list.removeToIndex(0);
        list.addToIndex(0,123);
        list.removeToIndex(list.size());
        //遍历list数组
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}
