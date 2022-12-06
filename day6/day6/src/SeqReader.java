import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class SeqReader {
    private final String fileName;

    public SeqReader(String fileName) {
        this.fileName = fileName;
    }

    public Set<Character> getHashSet(String line, int start, int end){
        Set<Character> res = new HashSet<>();
        for(int i = start; i < end; i++){
            res.add(line.charAt(i));
        }
        return res;
    }

    public int getSeq(int range) {
        try {
            String line = Files.readString(Path.of(fileName), StandardCharsets.UTF_8);
            for(int i = 0; i < line.length() - range; i++){
                Set<Character> checkSet = this.getHashSet(line, i, range + i);
                if(checkSet.size() == range){
                    return range + i;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}
