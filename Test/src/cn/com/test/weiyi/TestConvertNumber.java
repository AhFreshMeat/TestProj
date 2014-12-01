package cn.com.test.weiyi;

public class TestConvertNumber {
	public static void main(String[] args) {
		int convertNum = 20;
		String val = toUnsignedString(convertNum, 9);
		System.out.println(val);
	}

	private static String toUnsignedString(int num, int shift) {
		int charPos = 32;
		char[] buf = new char[charPos];
		int diagitsIdx = 0;
		do {
			diagitsIdx = num % shift;
			buf[--charPos] = digits[diagitsIdx];
			num = num / shift;
		} while (num != 0);
		return new String(buf, charPos, (32 - charPos));
	}

	final static char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
			'9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
			'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
			'Z' };
}
