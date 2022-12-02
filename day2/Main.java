public class Main {
    public static void main(String[] args) {
        RPSReader rr = new RPSReader("src\\day2.txt");
        Pair<Integer, Integer> score = rr.getScore();
        System.out.println(score.getLeft());
        System.out.println(score.getRight());
    }
}