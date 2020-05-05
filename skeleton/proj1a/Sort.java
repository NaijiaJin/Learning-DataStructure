public class Sort {



    public static void sort(String[] in)
    {
        // find the smallest item in the array

        // put it at the front of the array

        // selection sort the rest

        sort(in,0);




    }

    private static  void sort (String[] in, int start)
    {
        if(start==in.length)
        {
            return;
        }

        int smallest= findSmallest(in,start);
        // put it at the front of the array
        swap(in,start,smallest);
        // selection sort the rest
        sort(in,start+1);

    }


    public static int findSmallest(String[] in,int first)
    {
        int index=first;

        for (int i = first;i<in.length;i++)
        {
            int cmp=in[i].compareTo(in[index]);
            if(cmp<0)
            {
                index=i;
            }
        }

        return index;

    }

    public static void swap(String[] x, int a, int b)
    {
        String temp=x[a];
        x[a]=x[b];
        x[b]=temp;
    }


        /* summary of the selection sort :
    find the smallest
    swap the smallest with the front item
    selection sort the rest
     */


}
