package easy;

public class LengthOfLastWord {
    public static int lengthOfLastWord1(String s) {
        int size = 0;
        if(s.length() == 0) return size;
        for(int i = s.length() - 1; i >= 0; i--) {
        	if(s.charAt(i) == ' ') break;
        	size++;
        }
        return size;
    }
    //用到数组先判断与，先边界，在对数值判断，防止outofbound
    public static int lengthOfLastWord(String s) {
		int size = 0;
		if(s.length() == 0) return size;
		int i = s.length() - 1;
		while(i >= 0 && s.charAt(i) == ' ') i--;
		while(i >= 0 && s.charAt(i) != ' ') {
			size++;
			i--;
		}
		return size;
	}
    
    public static void main(String[] args) {
		String s = "Hello World";
		String a = "a ";
		System.out.println(lengthOfLastWord(s));
		System.out.println(lengthOfLastWord(a));
	}
}
