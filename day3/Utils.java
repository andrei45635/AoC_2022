import java.util.HashSet;

public class Utils {
    public int getPriority(HashSet<Character> hash){
        int priority = 0;
        for(char c: hash){
            if(c >= 'a' && c <= 'z'){
                priority += c - 96;
            } else if (c >= 'A' && c <= 'Z'){
                priority += c - 38;
            }
        }
        return priority;
    }

    public HashSet<Character> getHash(String first, String second){
        HashSet<Character> hash1 = new HashSet<>();
        HashSet<Character> hash2 = new HashSet<>();
        for(int i = 0; i < first.length(); i++){
            hash1.add(first.charAt(i));
        }
        for(int i = 0; i < second.length(); i++){
            hash2.add(second.charAt(i));
        }
        hash1.retainAll(hash2);
        return hash1;
    }
}
