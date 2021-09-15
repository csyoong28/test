package com.soonyoong.mockito;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Utility.class, CollaboratorWithStaticMethods.class})
public class Powermock_test {

	@Test
	public void TestStaticMethod_WithPowerMockito() {
		String call = " Hi there, I'm using PowerMock with Mockito ";
		String callexpectation = " Call Expectation for you. ";
		PowerMockito.mockStatic(Utility.class);
		PowerMockito.when(Utility.staticMethod(call)).thenReturn(callexpectation);
		String actualcall = Utility.staticMethod(call);
		assertEquals(callexpectation, actualcall); // success
	}
	
	@Test
	public void TestStaticMethod_WithPowerMockito2() {
		PowerMockito.mockStatic(CollaboratorWithStaticMethods.class);
		Mockito.when(CollaboratorWithStaticMethods.firstMethod(Mockito.anyString())).thenReturn("Hello Baeldung!");
		Mockito.when(CollaboratorWithStaticMethods.secondMethod()).thenReturn("Nothing special");
		String firstWelcome = CollaboratorWithStaticMethods.firstMethod("Whoever");
		String secondWelcome = CollaboratorWithStaticMethods.firstMethod("Whatever");
		assertEquals("Hello Baeldung!", firstWelcome);
		assertEquals("Hello Baeldung!", secondWelcome);
		PowerMockito.verifyStatic(Mockito.times(2));
		CollaboratorWithStaticMethods.firstMethod(Mockito.anyString());
		        
		PowerMockito.verifyStatic(Mockito.never());
		CollaboratorWithStaticMethods.secondMethod();
	}

	@Test
	public void TestPrivateMethod_WithPowerMock() throws Exception {
		String message = " PowerMock with Mockito and JUnit ";
		String expectedmessage = " Using with EasyMock ";
		Utility mock = PowerMockito.spy(new Utility());
		PowerMockito.doReturn(expectedmessage).when(mock, "privateMethod", message);
		String actualmessage = mock.callPrivateMethod(message);
		assertEquals(expectedmessage, actualmessage);
		System.out.println(PowerMockito.verifyPrivate(getClass()));
	}
	
	@Test
	public void TestFinalMethod_WithPowerMock() throws Exception {
		String message = " PowerMock with Mockito and JUnit ";
		Utility uti = PowerMockito.mock(Utility.class);
		PowerMockito.whenNew(Utility.class).withNoArguments().thenReturn(uti);
		Utility uti2 = new Utility();
		PowerMockito.verifyNew(Utility.class).withNoArguments();
		PowerMockito.when(uti2.finalMethod(message)).thenReturn(message);
		String message2 = uti2.finalMethod(message);
		Mockito.verify(uti2).finalMethod(message);
		assertEquals(message, message2);
	}
}