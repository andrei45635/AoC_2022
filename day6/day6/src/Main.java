public class Main {
    public static void main(String[] args) {
        SeqReader sr = new SeqReader("src\\test.txt");
        System.out.println(sr.getSeq(14));
    }
}