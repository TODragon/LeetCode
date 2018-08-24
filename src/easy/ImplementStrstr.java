package easy;

public class ImplementStrstr {
    public int strStr(String haystack, String needle) {
        if(needle.equals("")) return 0;
        for(int i = 0; i <= haystack.length() - needle.length(); i++){
            for(int j = 0; j < needle.length(); j++){
                if(haystack.charAt(i + j) != needle.charAt(j)) break;
                else if(j == needle.length() - 1) return i;
            }
        }
        return -1;
    }
//	jiuzhang solution
    public int strStr1(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        
        for (int i = 0; i < source.length() - target.length() + 1; i++) {
            int j = 0;
            for (j = 0; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
            // finished loop, target found
            if (j == target.length()) {
                return i;
            }
        }
        return -1;
    }
}
