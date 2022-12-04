import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class TaskReader {
    private final String fileName;

    public TaskReader(String fileName) {
        this.fileName = fileName;
    }

    public Pair<Integer, Integer> getOverlaps() {
        int overlaps = 0;
        int overlapsPart2 = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                List<String> elfTasks = List.of(line.split(","));
                List<String> elfs1 = List.of(elfTasks.get(0).split("-"));
                List<String> elfs2 = List.of(elfTasks.get(1).split("-"));
                int el11 = Integer.parseInt(elfs1.get(0));
                int el12 = Integer.parseInt(elfs1.get(1));
                int el21 = Integer.parseInt(elfs2.get(0));
                int el22 = Integer.parseInt(elfs2.get(1));
                if(((el11 <= el21) && (el12 >= el22)) || ((el11 >= el21) && (el12 <= el22))){
                    overlaps += 1;
                }
                if((el11 <= el22) && (el12 >= el21)){
                    overlapsPart2 += 1;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new Pair<>(overlaps, overlapsPart2);
    }
}
