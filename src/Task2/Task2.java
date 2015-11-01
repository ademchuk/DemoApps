package Task2;

import java.util.ArrayList;
/**
 * Created by User1 on 10/31/2015.
 */
public class Task2 {
    public static void main(String[] args) {
        int[] array1 = new int[] {9,12,14,14,2,34,6,7,9,12,97};
        int[] array2 = new int[] {13,45,56,57,13, 9, 0,12};

        ArrayList<Integer> arrayList1 = new ArrayList<Integer>();
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();

        fillArrayList(array1,arrayList1);
        fillArrayList(array2,arrayList2);

        System.out.println("Before sorting");
        printArray(arrayList1);
        printArray(arrayList2);

        arrayList1.sort(new IntComparator());
        arrayList2.sort(new IntComparator());

        System.out.println("After sorting");

        printArray(arrayList1);
        printArray(arrayList2);

        removeSameElements(arrayList1);
        removeSameElements(arrayList2);

        System.out.println("After cleaning");
        printArray(arrayList1);
        printArray(arrayList2);

        ArrayList<Integer> resultArray = findDifference(arrayList1,arrayList2);

        System.out.print("Result:  ");
        printArray(resultArray);
    }
    static void fillArrayList (int[] array, ArrayList<Integer> arrayList) {
        int size = array.length;
        for (int i=0; i < size; i++) {
            arrayList.add(array[i]);
        }
    }
    static void printArray(ArrayList<Integer> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i)+"  ");
        }
        System.out.println();
    }
    static void removeSameElements(ArrayList<Integer> arrayList) {

        for (int i = 0; i < arrayList.size()-1; i ++) {
            if (arrayList.get(i).equals(arrayList.get(i+1))){
                arrayList.remove(i+1);
            }
        }
    }
    static ArrayList<Integer> findDifference(ArrayList<Integer> arrayList1, ArrayList<Integer> arrayList2) {
        ArrayList<Integer> resultArray = new ArrayList<Integer>();

        int size1 = arrayList1.size();
        int size2 = arrayList2.size();
        int index = 0;

        for (int i = 0; i < size2 && index < size1; i ++) {
            while (arrayList2.get(i) > arrayList1.get(index)) {
                resultArray.add(arrayList1.get(index));
                index++;
            }
            if (arrayList2.get(i).equals(arrayList1.get(index))) {
                index++;
            }
        }
        while (index < size1) {
            resultArray.add(arrayList1.get(index));
            index++;
        }
        return resultArray;
    }
}
