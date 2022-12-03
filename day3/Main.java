import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        RucksackReader rr = new RucksackReader("src\\day3.txt");
        System.out.println(rr.readAllRucksacks());
        System.out.println(rr.readRucksack());
    }
}