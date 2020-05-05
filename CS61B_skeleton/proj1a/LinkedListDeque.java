import javax.print.DocFlavor;
import java.util.BitSet;

public class LinkedListDeque<AnyType> {

    public class BaseNode<AnyType>
    {
        public BaseNode prev;
        public AnyType item;
        public BaseNode next;

        public BaseNode(BaseNode p,AnyType i,BaseNode n )
        {
            prev=p;
            item=i;
            next=n;
        }
    }


    BaseNode sentinel;
    public int size=0;

    public LinkedListDeque(AnyType i)
    {
        sentinel= new BaseNode<>(null,i,null);
        size=0;
    }


    public LinkedListDeque()
    {

        sentinel= new BaseNode<Integer> (null,5,null);
        size=0;
    }

    public LinkedListDeque(LinkedListDeque other)
    {
        sentinel= new BaseNode(other.sentinel.prev,other.sentinel.item,other.sentinel.next);
    }

    public void addFirst(AnyType x)
    {
        BaseNode p=sentinel;

        if(sentinel.next!=null) {
            BaseNode p1 = sentinel.next;
            p.next=new BaseNode(sentinel,x,p.next);
            p1.prev=p.next;
        }
        else
        {

            p.next=new BaseNode(sentinel,x,null);
            p.prev=p.next;
            p.next.next=p;
        }

        size+=1;
    }



    public void addLast(AnyType x)
    {
        BaseNode p=sentinel;
        if(p.prev!=null) {
            BaseNode p1=p.prev;
            p.prev.next = new BaseNode(p1, x, p);
            p.prev=p1.next;
        }
        else
        {
            p.next=new BaseNode(sentinel,x,sentinel);
            p.prev=p.next;
        }

        size+=1;

    }

    public void printDeque()
    {
        if(isEmpty())
        {
            return;
        }

        BaseNode p= sentinel.next;
        while(p!=sentinel)
        {
            System.out.print(p.item);
            System.out.print(" ");
            p=p.next;
        }
        System.out.println(" ");
        System.out.println("-------------------------------------------------------");

    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size==0;
    }

    public AnyType removeFirst()
    {

        if(this.isEmpty())
        {
            return null;
        }
        else
        {
            size--;
            BaseNode p=sentinel;
            BaseNode rp=sentinel.next;
            BaseNode p1=sentinel.next;
            p.next=p1.next;
            p1.next.prev=p;

            AnyType rItem= (AnyType) rp.item;
            return rItem;
        }

    }

    public AnyType removeLast()
    {
        if(this.isEmpty())
        {
            return null;
        }
        else
        {
            size--;
            BaseNode p=sentinel;
            BaseNode rp= sentinel.prev;
            BaseNode p1=sentinel.prev;

            p.prev=p1.prev;
            p1.prev.next=p;

            AnyType rItem= (AnyType) rp.item;
            return rItem;
        }
    }

    public AnyType get(int x)
    {
        BaseNode p=sentinel;
        for (int num=1;num<=x;num++)
        {
            if(p.next!=p)
            {
                p=p.next;
            }
            else
                return null;
        }
        AnyType item=(AnyType) p.item;
        return item;

    }

    private  AnyType GetRecursive(BaseNode p,int x)
    {
        if(x==0)
        {
            return (AnyType) p.item;
        }
        else
        {
            p=p.next;
            return (AnyType) GetRecursive(p,x-1);
        }


    }

    public AnyType getRecursive(int x)
    {
        if(x==0)
        {
            return (AnyType) this.sentinel.next.item;
        }
        else
        {
            BaseNode p=sentinel.next;
            return (AnyType) GetRecursive(p,x);

        }

    }

    public static void main(String[] args) {
        LinkedListDeque L= new LinkedListDeque();


        L.addFirst(20);
        System.out.println(L.isEmpty());
        System.out.println(L.size());
        L.removeFirst();
        System.out.println(L.size());
        System.out.println(L.isEmpty());




    }



}
