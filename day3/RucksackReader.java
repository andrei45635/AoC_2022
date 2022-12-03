import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class RucksackReader {
    private final String fileName;

    public RucksackReader(String fileName) {
        this.fileName = fileName;
    }

    public int part1(String line){
        Utils util = new Utils();
        int priority;
        String first = line.substring(0, line.length() / 2);
        String second = line.substring(line.length() / 2);
        HashSet<Character> hash1 = util.getHash(first, second);
        priority = util.getPriority(hash1);
        return priority;
    }

    public int readAllRucksacks() throws IOException {
        int badgePriority = 0;
        Utils util = new Utils();
        List<String> rucksacks = Files.readAllLines(Path.of(fileName));
        for(int i = 0; i < rucksacks.size(); i += 3){
            String ruck1 = rucksacks.get(i);
            String ruck2 = rucksacks.get(i + 1);
            String ruck3 = rucksacks.get(i + 2);
            HashSet<Character> hashR1R2 = util.getHash(ruck1, ruck2);
            HashSet<Character> hashR3 = new HashSet<>();
            for(int j = 0; j < ruck3.length(); j++){
                hashR3.add(ruck3.charAt(j));
            }
            hashR1R2.retainAll(hashR3);
            badgePriority += util.getPriority(hashR1R2);
        }
        return badgePriority;
    }

    public int readRucksack() {
        int priority = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                priority += part1(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return priority;
    }
}
