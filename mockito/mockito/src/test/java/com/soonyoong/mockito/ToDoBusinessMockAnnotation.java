package com.soonyoong.mockito;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ToDoBusinessMockAnnotation {
	@Mock
	ToDoService servicemock;
	@InjectMocks
	ToDoBusiness business;
	@Captor
	ArgumentCaptor<String> argumentCaptor;
	@Spy
	ArrayList<String> arraylistSpy;
	
	@Test
	public void deleteTodosusing_BDD() {
		// Given
		List<String> combinedlist = Arrays.asList("Use Hibernate Java", "Use Hibernate Core", "Use Hibernate", "Use Spring MVC");
		given(servicemock.getTodos("dummy")).willReturn(combinedlist);
		arraylistSpy.add("Mockito1");
		arraylistSpy.add("Mockito2");
		// When
		business.deleteTodosNotRelatedToHibernate("dummy");
		// Then
		verify(arraylistSpy).add("Mockito1");
		verify(arraylistSpy).add("Mockito2");
		verify(servicemock, times(1)).deleteTodos("Use Spring MVC");
		verify(servicemock, never()).deleteTodos("Use Hibernate Java");
		verify(servicemock, never()).deleteTodos("Use Hibernate");
		assertEquals(2, arraylistSpy.size());
		System.out.println("test is working..");
	}

	@Test
	public void deleteTodosusing_BDD_usingArgumentCaptor() {
		// Given
		List<String> combinedlist = Arrays.asList("Use Hibernate Java", "Use Hibernate Core", "Use Hibernate", "Use Spring MVC");
		given(servicemock.getTodos("dummy")).willReturn(combinedlist);
		// When
		business.deleteTodosNotRelatedToHibernate("dummy");
		// Then
		then(servicemock).should().deleteTodos(argumentCaptor.capture());
		assertThat(argumentCaptor.getValue(), is("Use Spring MVC"));
		System.out.println("test is working..");
	}
}
