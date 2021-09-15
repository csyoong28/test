package com.soonyoong.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
@RunWith(MockitoJUnitRunner.class)
public class TEX_01_MockitoWhenThenTest {
	interface SomeDummyInterface {
		int getStringLength(String str);
	}

	@Mock
	SomeDummyInterface someDummyInterface;

	@Test
	public void testWhenThenReturn() {
		int returnValue = 5;
		Mockito.when(someDummyInterface.getStringLength("dummy")).thenReturn(returnValue);
		doReturn(returnValue).when(someDummyInterface).getStringLength("dummy");
	}

	@Test
	public void testThenAnswer() {
		Answer<Integer> answer = invocation -> {
			String string = (String) invocation.getArguments()[0];
			return string.length() * 5;
		};

		when(someDummyInterface.getStringLength("dummy")).thenAnswer(answer);
		Mockito.doAnswer(answer).when(someDummyInterface).getStringLength("dummy");
		assertEquals(25, someDummyInterface.getStringLength("dummy"));
	}
}
