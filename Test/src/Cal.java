import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Cal {
	public static void main(String[] args) {
		// TestDate();
		TestDecimal();
		// TestToOctal();
		String test = toOctalString(100);
		// System.out.println(test);
	}

	public static String toOctalString(int i) {
		byte a = 64, b;
		i = a << 2;
		b = (byte) (a << 2);
		System.out.println("Original value of a: " + a);
		System.out.println("i and b: " + i + " " + b);
		return null;
		// return toUnsignedString(i, 2);
	}

	private static String toUnsignedString(int i, int shift) {
		char[] buf = new char[32];
		int charPos = 32;
		int radix = 1 << shift;
		int mask = radix - 1;
		do {
			buf[--charPos] = digits[i & mask];
			i >>>= shift;
		} while (i != 0);
		return new String(buf, charPos, (32 - charPos));
	}

	final static char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
			'9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
			'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
			'z' };

	private static int convertToOctal(int testNumber) {
		int highPos = testNumber / 8;
		int lowPos = testNumber % 8;
		testNumber = highPos * 10 + lowPos;
		return testNumber;
	}

	private static void TestDecimal() {
	}

	private static void TestDate() {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = getBeforeXDay(now, 30);
		System.out.println(sdf.format(now));
		System.out.println(sdf.format(date));
	}

	private static Date getBeforeXDay(Date date, int xDday) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, -xDday);
		return cal.getTime();
	}
}
