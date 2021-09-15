package com.soonyoong.mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

public class TestList {

	@Test
	public void testList_ReturnsSingle_value() {
		List mocklist = mock(List.class);
		when(mocklist.size()).thenReturn(1);
		assertEquals(1, mocklist.size());
		assertEquals(1, mocklist.size());
		System.out.println(mocklist.size());
		System.out.println(mocklist);
	}

	@Test
	public void testList_Returns_MultipleValues() {
		List mocklist = mock(List.class);
		when(mocklist.size()).thenReturn(1).thenReturn(2).thenReturn(3);
		assertEquals(1, mocklist.size());
		assertEquals(2, mocklist.size());
		assertEquals(3, mocklist.size());
		System.out.println(mocklist.size());
		System.out.println(mocklist);
	}

	@Test
	public void testList_get() {
		List mocklist = mock(List.class);
		when(mocklist.get(0)).thenReturn("Mockito");
		assertEquals("Mockito", mocklist.get(0));
		System.out.println(mocklist.get(0));
	}

	@Test
	public void testList_Argument_Matchers() {
		List<String> mocklist = mock(List.class);
		when(mocklist.get(Mockito.anyInt())).thenReturn("Mockito");
		assertEquals("Mockito", mocklist.get(0));
		assertEquals("Mockito", mocklist.get(1));
		assertEquals("Mockito", mocklist.get(2));
	}

	@Test(expected = RuntimeException.class)
	public void testList_ThrowsException() {
		List<String> mocklist = mock(List.class);
		when(mocklist.get(Mockito.anyInt())).thenThrow(new RuntimeException("Error.."));
		mocklist.get(0);
	}
	
	@Test
	public void testList_usingBDD() {
		//Given - setup part  
		List<String> mocklist = mock(List.class);
		given(mocklist.get(Mockito.anyInt())).willReturn("Mockito");
		//When - invocation   
		String string1 = mocklist.get(0);
		//Then - readable assert  
		assertThat(string1, is("Mockito"));
	}
}
