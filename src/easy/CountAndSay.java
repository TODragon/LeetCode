package easy;

public class CountAndSay {
	public static String countAndSay(int n) {
		String str = "1";
		
		for(int m = 1; m < n; m++) {
			int i = 0;
			String string = new String();
			while(i < str.length()) {
				int j = i + 1;
				while(j < str.length()) {
					if(str.charAt(j) == str.charAt(i)) j++;
					else break;
				}
				string = string + (j - i) +str.charAt(i);
				i = j;
			}
			str = string;
		}
		
		return str;
	}
	
    public String countAndSay1(int n) {
        String oldString = "1";
        while (--n > 0) {
            StringBuilder sb = new StringBuilder();
            char [] oldChars = oldString.toCharArray();

            for (int i = 0; i < oldChars.length; i++) {
                int count = 1;
                while ((i+1) < oldChars.length && oldChars[i] == oldChars[i+1]) {
                    count++;
                    i++;
                }
                sb.append(String.valueOf(count) + String.valueOf(oldChars[i]));
            }
            oldString = sb.toString();
        }

        return oldString;
    }
	
	public static void main(String[] args) {
		for(int i = 1; i < 6; i++) {
			System.out.println(countAndSay(i));
		}
//		System.out.println(countAndSay(1));
//		System.out.println(countAndSay(2));
	}
}
