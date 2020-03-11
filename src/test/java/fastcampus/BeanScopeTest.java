package fastcampus;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class BeanScopeTest {
	@Test
	void testIdentity(){
		/****
		 * 동일성 : 객체의 주소 같다.
		 * 동등성 : 객체의 값이 같다.
		 */
		A a1 = new A();
		A a2  = new A();
		Assert.assertTrue(a1 != a2);

	}

	@Test
	void testEqual(){
		A a1 = new A(10,"Hello World");
		A a2 = new A(10,"Hello World");

		A a3 = new A(5,"Hello");

		Assert.assertTrue(a1.equals(a2));
		Assert.assertFalse(a1.equals(a3));
	}
}
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
class A{
	private int a1;
	private String a2;
}
