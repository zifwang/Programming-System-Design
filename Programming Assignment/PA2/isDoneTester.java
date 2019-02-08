import java.util.*;
public class isDoneTester{
    public static void main(String[] args) {
        SolitaireBoard sb;
        ArrayList<Integer> mArrayList = new ArrayList<Integer>();
        for(int i = 0; i < 9; i++){
            mArrayList.add(9-i);
        }
        // mArrayList.set(1,1);
        mArrayList.set(0,2);
        mArrayList.set(1,7);
        mArrayList.set(2,1);
        mArrayList.set(3,8);
        mArrayList.set(4,3);
        mArrayList.set(5,4);
        mArrayList.set(6,6);
        mArrayList.set(7,6);
        mArrayList.set(8,8);


        System.out.println(mArrayList);
        sb = new SolitaireBoard(mArrayList);
        boolean checker = sb.isDone();
        System.out.println(checker);

    }

}