package com.soonyoong.mockito;

import static org.junit.Assert.*;
import org.junit.Test;
import org.mockito.Mockito;
import junit.framework.Assert;

public class Abstract1Test {
	@Test
	public void testing_usingSpy() {
		Abstract1_class abstclas = Mockito.spy(Abstract1_class.class);
		String res = abstclas.methodUnderTest();
		Assert.assertEquals("one", res);
	}
}
