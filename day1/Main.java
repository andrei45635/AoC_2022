import java.util.List;

public class Main {
    public static void main(String[] args) {
        ElfReader er = new ElfReader("src\\elfs.txt");
        List<Integer> calories = er.getCals();
        //Part 1
        System.out.println(calories.get(calories.size() - 1));

        //Part 2
        System.out.println(calories.get(calories.size() - 1) + calories.get(calories.size() - 2) + calories.get(calories.size() - 3));
    }
}