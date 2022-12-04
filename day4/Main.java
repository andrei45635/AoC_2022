public class Main {
    public static void main(String[] args) {
        TaskReader tr = new TaskReader("src\\tasks.txt");
        Pair<Integer, Integer> resPair = tr.getOverlaps();
        System.out.println(resPair.getLeft());
        System.out.println(resPair.getRight());
    }
}