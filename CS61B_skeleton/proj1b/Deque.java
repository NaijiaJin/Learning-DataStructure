public interface Deque<Item> {


    void addFirst(Item x);

    void addLast(Item x);

    default boolean isEmpty()
    {
        int i =size();
        if(i==0)
            return true;
        return false;
    };

    Item removeFirst();

    Item removeLast();

    void printDeque();

    Item get(int index);

    int size();



}
