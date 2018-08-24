package easy;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s.length() == 0) return true;
        //split多种字符分割用[]表示即可
        String[] a = s.split("[^a-zA-Z0-9]");
        String str = "";
        for(String string: a) {
            str += string;
        }
        str = str.toLowerCase();
        for(int i = 0; i < str.length() / 2; i++) {
            if(str.charAt(i) != str.charAt(str.length() - i - 1)) return false;
        }
        return true;
    }


    //jiuzhang solution
    public boolean isPalindrome1(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int front = 0;
        int end = s.length() - 1;
        while (front < end) {
            while (front < s.length() && !isvalid(s.charAt(front))){ // nead to check range of a/b
                front++;
            }

            if (front == s.length()) { // for empty string “.,,,”
                return true;
            }

            while (end >= 0 && ! isvalid(s.charAt(end))) { // same here, need to check border of a,b
                end--;
            }

            if (Character.toLowerCase(s.charAt(front)) != Character.toLowerCase(s.charAt(end))) {
                break;
            } else {
                front++;
                end--;
            }
        }

        return end <= front;
    }

    private boolean isvalid (char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }

}
