import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ElfReader {
    private String fileName;

    public ElfReader(String fileName) {
        this.fileName = fileName;
    }

    public List<Integer> getCals() {
        List<Integer> calories = new ArrayList<>();
        int cal_sum = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    cal_sum += Integer.parseInt(line);
                } else {
                    calories.add(cal_sum);
                    cal_sum = 0;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return calories.stream().sorted().toList();
    }
}
