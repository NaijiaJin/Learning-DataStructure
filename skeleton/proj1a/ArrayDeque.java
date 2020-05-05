public class ArrayDeque<Item> {

    private Item[] items;
    private int size;
    private int nextFirst;
    private int nextLast;


    public ArrayDeque()
    {
           items= (Item[]) new Object [8];
           size=0;
           nextFirst=0;
           nextLast=1;

    }

    public ArrayDeque(Item a)
    {
        Item[] items=(Item[]) new Object[8];
        items [0]=a;
        size=1;
        nextFirst=0;
        nextLast=7;
    }

    public int minusOne(int index)
    {
        if(index-1<0)
        {
            return items.length-1;
        }

        int i =index-1;
        return i;
    }

    public int plusOne(int index)
    {
        if(index+1>items.length-1)
        {
            return 0;
        }

        return index+1;
    }




    public void addFirst(Item x)
    {
        if(size==items.length)
        {
            resize(size*2);
        }
        items[nextFirst]=x;
        nextFirst=minusOne(nextFirst);
        size+=1;
    }

    public void addLast(Item x)
    {
        if(size==items.length)
        {
            resize(size*2);
        }
        items[nextLast]= x;
        nextLast=plusOne(nextLast);
        size+=1;

    }


    private void resize(int capacity)
    {
        Item[] a= (Item[]) new Object [capacity];

        int current=plusOne(nextFirst);
        for(int i=0;i<size;i++)
        {
            a[i]=items[current];
            current=plusOne(current);
        }

        items=a;
        nextFirst=items.length-1;
        nextLast=size;


    }

    public boolean isEmpty()
    {
        if(size==0)
        {
            return true;
        }
        return false;
    }


    public Item removeFirst()
    {
        if(isEmpty())
        {
            return null;
        }
        if(size/items.length<0.25&&size<=16)
        {
            resize(size/2);
        }

        int currentFirst=plusOne(nextFirst);
        Item f=items[currentFirst];
        items[currentFirst]=null;
        nextFirst=currentFirst;
        size--;
        return f;

    }

    public Item removeLast()
    {
        if(size==0)
        {
            return null;
        }

        if(size/items.length<0.25&&size>=16)
        {
            resize(size/2);
        }

        int currentLast=minusOne(nextLast);// 为了得到current last next last的前一个才位置才是当前的最后last
        Item l=items[currentLast];
        items[currentLast]=null;
        nextLast=currentLast;
        size--;

        return l;

    }

    public void printDeque()
    {
        int i=0;
        int current=plusOne(nextFirst);
        while(i<size)
        {
            System.out.print(items[current]);
            current=plusOne(current);
            i++;
        }
    }

    private boolean isExist(int index)
    {
        if (index<nextLast||index>nextFirst)
        {
            return true;
        }
        return false;
    }


    public Item get(int index)
    {
        if(isExist(index))
        {
            return items[index];
        }
        else
            return null;

    }



    public static void main(String[] args) {
        ArrayDeque a=new ArrayDeque();
        a.addLast(10);
        a.addFirst(99);
        a.addLast(20);
        a.removeLast();

        System.out.println(a.get(1));
        a.printDeque();

    }

}
