package cn.com.test.weiyi;

public class TestIntegerConvertNumber {
	public static void main(String[] args) {
		 System.out.println(toBinaryString(20));
	}

	/**
	 * Returns a string representation of the integer argument as an unsigned
	 * integer in base&nbsp;2.
	 */
	public static String toBinaryString(int i) {
		return toUnsignedString(i, 1);
	}

	/**
	 * Convert the integer to an unsigned number.
	 */
	private static String toUnsignedString(int i, int shift) {
		// 转换结果集
		char[] buf = new char[32];
		// 结果集下标
		int charPos = 32;
		// 得到进制（除数）
		int radix = 1 << shift;
		// 取余，radix仅能为2的N次方，mask为2的N次方-1，即11111.....111
		// 当1与其它数&时，以其它数为准，从而快速得到余数
		int mask = radix - 1;
		do {
			// 将余数倒置在结果集中
			buf[--charPos] = digits[i & mask];
			// 将商的值赋值给被除数
			i >>>= shift;
			// 商为0时结束
		} while (i != 0);

		return new String(buf, charPos, (32 - charPos));
	}

	/**
	 * All possible chars for representing a number as a String
	 */
	final static char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
			'9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
			'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
			'z' };
}
