package easy;

public class Roman2Integer {
	public static int romanToInt(String s) {
		
		int solution = 0;
		char last = 'I';
		char[] roman = s.toCharArray();
		for(int i = s.length() - 1; i >= 0; i--) {
			if(roman[i] == 'I') {
				if (last == 'V' || last == 'X') {
					solution -= 1;
				}
				else solution += 1;
			}
			if (roman[i] == 'V') {
				solution += 5;
			}
			if(roman[i] == 'X') {
				if (last == 'L' || last == 'C') {
					solution -= 10;
				}
				else solution += 10;
			}
			if(roman[i] == 'L') {
				solution += 50;
			}
			if(roman[i] == 'C') {
				if (last == 'D' || last == 'M') {
					solution -= 100;
				}
				else solution += 100;
			}
			if(roman[i] == 'D') {
				solution += 500;
			}
			if(roman[i] == 'M') {
				solution += 1000;
			}
			
			last = roman[i];
		}
		return solution;
	}
//	test
	public static void main(String[] args) {
		System.out.println(romanToInt("III"));
		System.out.println(romanToInt("IV"));
		System.out.println(romanToInt("IX"));
		System.out.println(romanToInt("LVIII"));
		System.out.println(romanToInt("MCMXCIV"));
	}
}
