import static org.junit.Assert.*;
import org.junit.Test;

public class SortTest {

   @Test

    public  void sortTest()
    {
        String[] input= new String[]{"i","have","an","egg"};
        String[] expected=new String[]{"an","egg","have","i"};

        Sort.sort(input);


        assertArrayEquals(input,expected);

    }


    @Test

    public  void testFindSmallest()
    {
        String[] input= new String[]{"i","have","an","egg"};
        int small= Sort.findSmallest(input,0);
        int expected= 2;

       assertEquals(expected,small);


    }

    @Test

    public void testSwap()
    {
        String[] input= new String[]{"i","have","an","egg"};
        int a =0;
        int b= 2;

        String[] expected = {"an", "have", "i", "egg"};

        Sort.swap(input, a, b);
       assertArrayEquals(expected, input);

    }

    /* summary of the selection sort :
    find the smallest
    swap the smallest with the front item
    selection sort the rest
     */




}
