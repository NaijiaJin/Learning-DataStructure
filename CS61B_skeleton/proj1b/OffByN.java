public class OffByN implements CharacterComparator {

    int n;

    public OffByN(int x)
    {
        n=x;
    }

    @Override
    public boolean equalChars(char x, char y)
    {
        return Math.abs(y-x)==n;
    }



}
