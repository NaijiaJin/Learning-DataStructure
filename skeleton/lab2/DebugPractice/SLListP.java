import java.awt.desktop.SystemSleepEvent;

public class SLListP {

    public IntNode sentinel;
    public int size=0;

    public SLListP(int x)
    {
        sentinel= new IntNode(65,null);

        sentinel.next= new IntNode(x,null);
        size+=1;
    }

    public SLListP()
    {
        sentinel= new IntNode(65,null);
        size=0;
    }



    /* ADD x to the front of the list */
    public void addFirst (int x)
    {
        sentinel.next= new IntNode(x,sentinel.next);
        size++;

    }
    /* adds an item to the end of the list */

    public void addLast(int x)
    {
        IntNode f=sentinel;

        while (f.next!=null)
        {
            f=f.next;
        }
        f.next=new IntNode(x,null);
        size++;
    }
    /* return the first item in the list */
    public int getFirst()
    {
         return (this.sentinel.next.item);

    }
    /* the secret language of god */
    private static int recursiveSize(IntNode l)
    {
        if(l.next==null)
        {
            return 1;
        }
        return 1+ recursiveSize(l.next);

    }

/*
    public int recursiveSize()
    {
      //  return recursiveSize(first);

    }
*/

    public static void main(String[] args) {
        SLListP L=new SLListP();
        L.addLast(20);
        L.addFirst(10);
        System.out.println(L.size);

    }




}
