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
		// ת�������
		char[] buf = new char[32];
		// ������±�
		int charPos = 32;
		// �õ����ƣ�������
		int radix = 1 << shift;
		// ȡ�࣬radix����Ϊ2��N�η���maskΪ2��N�η�-1����11111.....111
		// ��1��������&ʱ����������Ϊ׼���Ӷ����ٵõ�����
		int mask = radix - 1;
		do {
			// �����������ڽ������
			buf[--charPos] = digits[i & mask];
			// ���̵�ֵ��ֵ��������
			i >>>= shift;
			// ��Ϊ0ʱ����
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
