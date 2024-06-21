import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        List<Integer> originalList = makeRedomList(100);
        List<Integer> copyList = new ArrayList<>(originalList);
        System.out.println("originalList: " + originalList);

        Random random = new Random();
        int randomIndex = random.nextInt(originalList.size());
        int removedNum = copyList.remove(randomIndex);
        System.out.println("after removed: " + copyList);

        int missingElement = findMissingElement(originalList, copyList);

        boolean isMissingElementFound = removedNum == missingElement;

        System.out.println("missing element: " + missingElement + "\n" + "removed Index: " + originalList.indexOf(missingElement));
        System.out.println(isMissingElementFound);

    }

    public static List<Integer> makeRedomList(int size){
        List<Integer> redomList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            redomList.add(random.nextInt(101)); // random number between 0 nad 100
        }
        return redomList;
    }

    private static int findMissingElement(List<Integer> originalList, List<Integer> copyList) {
        for (int index = 0; index <= originalList.size(); index++) {
            if (!originalList.get(index).equals(copyList.get(index))){
                return originalList.get(index);
            }
        }
        return -1; // if nothing missing
    }
}
