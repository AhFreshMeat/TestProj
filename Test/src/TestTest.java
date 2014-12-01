
public class TestTest {
	public static void main(String[] args) {
		Test t = new Test();
		Test t1 = new Test();
		t.setStr("str");
		t1.setStr("str");
		System.out.println(t.equals(t1));
	}
}
