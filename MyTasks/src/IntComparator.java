import java.util.Comparator;

/**
 * Created by User1 on 11/1/2015.
 */
public class IntComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1-o2;
    }
}
