public class Palindrome {

    public Deque<Character> wordToDeque(String word)
    {

      //  LinkedListDeque<Character> myList= new LinkedListDeque<>();
        ArrayDeque<Character> myList=new ArrayDeque<>();

        for (int i=0;i<word.length();i++)
        {
            myList.addLast(word.charAt(i));

        }

        return myList;
    }


    public boolean isPalindrome(String word)
    {

        int j=word.length()-1;
        for (int i=0;i<word.length()/2;i++)
        {
            if(word.charAt(i)==word.charAt(j))
            {
                j--;
                continue;
            }
            else
            {
                return  false;
            }

        }
        return true;

    }

    public boolean isPalindrome(String word, CharacterComparator cc)
    {
        int num=word.length()-1;

        for (int i=0;i<word.length()/2;i++)
        {
            if(cc.equalChars(word.charAt(i),word.charAt(num)))
            {
                num--;
                continue;
            }
            return false;
        }
        return true;
    }


    public boolean isPalindrome(String word, OffByN cc)
    {
        int num=word.length()-1;

        for (int i=0;i<word.length()/2;i++)
        {
            if(cc.equalChars(word.charAt(i),word.charAt(num)))
            {
                num--;
                continue;
            }
            return false;
        }
        return true;
    }



}
