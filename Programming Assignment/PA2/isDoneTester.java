import java.util.*;
public class isDoneTester{
    public static void main(String[] args) {
        SolitaireBoard sb;
        ArrayList<Integer> mArrayList = new ArrayList<Integer>();
        for(int i = 0; i < 9; i++){
            mArrayList.add(9-i);
        }
        // mArrayList.set(1,1);
        mArrayList.set(5,10);

        System.out.println(mArrayList);
        sb = new SolitaireBoard(mArrayList);
        boolean checker = sb.isDone();
        System.out.println(checker);

    }

}